package com.teamProject.erp.service;

import com.teamProject.erp.common.Search.Search;
import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.dto.MeetingDTO;
import com.teamProject.erp.dto.ValidateMemberDTO;
import com.teamProject.erp.mapper.mroom.MeetingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class MeetingRoomService {
    //private final 한 세트 @RequiredArgsConstructor이거를 안해주면 생성자 생성이 안됨.
    private final MeetingMapper meetingMapper;

    // 게시물 등록 요청 중간 처리
    @Transactional
    public boolean saveService(MeetingDTO mrBoardDto) {
        log.info("save service start - {}", mrBoardDto);

        // 게시물 내용 DB에 저장
        boolean flag = meetingMapper.save(mrBoardDto);

        List<String> fileNames = mrBoardDto.getFileNo();
        if (fileNames != null && fileNames.size() > 0) {
            for (String fileName : fileNames) {
                //첨부파일 내용 DB에 저장
                meetingMapper.addFile(fileName);
            }
        }

        return flag;
    }

    // 게시물 전체 조회 요청 중간 처리 with paging
    public Map<String, Object> findAllService(Page page) {
        log.info("findAll service start");

        Map<String, Object> findDataMap = new HashMap<>();

        List<MeetingDTO> mrList = meetingMapper.findAll(page);
        // 목록 중간 데이터 처리
        processConverting(mrList);

        findDataMap.put("mList", mrList);
        findDataMap.put("tc", meetingMapper.getTotalCount());

        return findDataMap;
    }

    // 게시물 전체 조회 요청 중간 처리 with searching
    public Map<String, Object> findAllService(Search search) {
        log.info("findAll service start");

        Map<String, Object> findDataMap = new HashMap<>();

        List<MeetingDTO> mrList = meetingMapper.findAll2(search);
        //목록 중간 데이터 처리
        processConverting(mrList);

        findDataMap.put("mList", mrList);
        findDataMap.put("tc", meetingMapper.getTotalCount2(search));

        return findDataMap;
    }

    private void processConverting(List<MeetingDTO> mrList) {
        for (MeetingDTO m : mrList) {
            convertDateFormat(m);
            substringTitle(m);
            checkNewArticle(m);
//            setReplyCount(m); 댓글 안넣음
        }
    }

//    private void setReplyCount(MeetingDTO m) {m.setReplyCount()} 댓글

    // 신규 게시물 여부 처리
    private void checkNewArticle(MeetingDTO m) {
        // 게시물의 작성일자와 현재 시간을 대조

        //게시물의 작성일자 가져오기 - 16억 5초
        long regDateTime = m.getMrTime().getTime();

        //현재 시간 얻기 (밀리초) - 16억 10초
        long nowTime = System.currentTimeMillis();

        // 현재시간 - 작성시간
        long diff = nowTime - regDateTime;

        // 신규 게시물 제한시간
        long limitTime = 60 * 5 * 1000;

        if (diff < limitTime) {
            m.setMewArticle(true);
        }
    }

    private void convertDateFormat(MeetingDTO m) {
        Date date = m.getMrTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd a hh:mm");
        m.setPrettierDate(sdf.format(date));
    }

    private void substringTitle(MeetingDTO m) {
        //만약에 글제목이 5글자 이상이라면
        // 5글자만 보여주고 나머지는 ... 처리
        String title = m.getMrTitle();
        if (title.length() > 5) {
            String subStr = title.substring(0, 5);
            m.setShortTitle(subStr + "...");
        } else {
            m.setShortTitle(title);
        }
    }

     //게시물 상세 조회 요청 중간 처리
    @Transactional
    public MeetingDTO findOneService(Long mrNo, HttpServletResponse response, HttpServletRequest request) {
        log.info("findOne service start - {}", mrNo);
        MeetingDTO meetingDTO = meetingMapper.findOne(mrNo);

        // 해당 게시물 번호에 해당하는 쿠키가 있는지 확인
        // 쿠키가 없으면 조회수를 상승시켜주고 쿠키를 만들어서 클라이언트에 전송
        makeViewCount(mrNo, response, request);

        return meetingDTO;
    }

    private void makeViewCount(Long mrNo, HttpServletResponse response, HttpServletRequest request) {
        // 쿠키를 조회 - 해당 이름의 쿠키가 있으면 쿠키가 들어오고 없으면 null이 들어옴
        Cookie foundCookie = WebUtils.getCookie(request, "m" + mrNo);

        if (foundCookie == null) {
            meetingMapper.upViewCount(mrNo);

            Cookie cookie = new Cookie("m" + mrNo, String.valueOf(mrNo)); // 쿠키생성
            cookie.setMaxAge(60); // 쿠키 수명 설정
            cookie.setPath("/meetingDTO/content"); // 쿠키 작동 범위

            response.addCookie(cookie); // 클라이언트에 쿠키 전송
        }
    }

    // 게시물 삭제 요청 중간 처리
    @Transactional
    public boolean removeService(Long mrNo) {
        log.info("remove service start - {}", mrNo);

        // 댓글 먼저 모두 삭제
//        replyMapper.removeAll(boardNo);
        //원본 게시물 삭제
        boolean remove = meetingMapper.remove(mrNo);
        return remove;
    }

    // 게시물 수정 요청 중간 처리
    public boolean modifyService(MeetingDTO mrBoard) {
        log.info("modify service start - {}", mrBoard);
        return meetingMapper.modify(mrBoard);
    }

    // 첨부파일 목록 가져오는 중간 처리
    public List<String> getFiles(Long mno) { return meetingMapper.findFileNames(mno); }

    // 게시물 번호로 글쓴이 회원정보 가져오기
    public ValidateMemberDTO getMember(Long mrNo) { return meetingMapper.findMemberByMrNo(mrNo); }

//    // 목록
//    public Map<String, Object> finAll() {
//        log.info("Meeting findAll service");
//        // HashMap() -> Map은 키와 값으로 구성된 Entry객체를 저장하는 구조를 가지고 있는 자료구조
//        Map<String, Object> findDataMap = new HashMap<>();
//
//        // meetingMapper에 있는 데이터베이스의 meetingroom 테이블 컬럼을 meetingList에 담아줌.
//        // meetingList를 HashMap에 등록함. mrList는 key값, meetingList는 value값이다.
//        List<MeetingDTO> meetingList = meetingMapper.findAll();
//        findDataMap.put("mrList", meetingList);
//
//        return findDataMap;
//    }
//
//    // 수정
//    public Map<String, Object> modifyMeeting(String userId) {
//        log.info("meeting ModifyMeeting service 호출됨");
//
//        Map<String, Object> findDataMap = new HashMap<>();
//
//        List<MeetingDTO> meetingModify = meetingMapper.modifyMeeting(userId);
//        findDataMap.put("mrModify", meetingModify);
//
//        return findDataMap;
//    }
//
//    // 삭제
//    public Map<String, Object> deleteMeeting(String userId) {
//        log.info("meeting DeleteMeeting service 호출됨");
//
//        Map<String, Object> findDataMap = new HashMap<>();
//
//        List<MeetingDTO> meetingDelete = meetingMapper.deleteMeeting(userId);
//        findDataMap.put("mrDelete", meetingDelete);
//
//        return findDataMap;
//    }
//
//    // 예약
//    public Map<String, Object> resvMeeting(String userId) {
//        log.info("meeting ResvMeeting service 호출됨");
//
//        Map<String, Object> findDataMap = new HashMap<>();
//
//        List<MeetingDTO> meetingResv = meetingMapper.resvMeeting(userId);
//        findDataMap.put("mrResv", meetingResv);
//
//        return findDataMap;
//    }
}
