package com.teamProject.erp.service;

import com.teamProject.erp.common.Search.Search;
import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.dto.NoticeDTO;
import com.teamProject.erp.mapper.notice.NoticeMapper;
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
public class NoticeService {

    private final NoticeMapper noticeMapper;

    @Transactional
    public boolean noticeInsertService(NoticeDTO noticeDTO) {
        log.info("noticeInsert Service start - {}", noticeDTO);

        // 게시물 내용 DB에 저장
        boolean flag = noticeMapper.noticeInsert(noticeDTO);

        List<String> fileNames = noticeDTO.getNoticeFileNames();
        if(fileNames != null && fileNames.size() > 0) {
            for (String fileName : fileNames) {
                // 첨부파일 내용 DB에 저장
                noticeMapper.noticeAddFile(fileName);
            }
        }
        return flag;
    }

    // 게시물 전체 조회 요청 중간 처리
    public List<NoticeDTO> noticeFindAllService() {
        log.info("noticeFindAll service start");
        List<NoticeDTO> noticeDTOList = noticeMapper.noticeFindAll();

        // 목록 중간 데이터처리
        noticeProcessConverting(noticeDTOList);

        return noticeDTOList;
    }

    // 게시물 전체 조회 요청 중간 처리 with paging
    public Map<String, Object> noticeFindAllService(Page page) {
        log.info("noticeFindAll service start");

        Map<String, Object> findDataMap = new HashMap<>();

        List<NoticeDTO> noticeDTOList = noticeMapper.noticeFindAll(page);

        // 목록 중간 데이터 처리
        noticeProcessConverting(noticeDTOList);

        findDataMap.put("nList", noticeDTOList);
        findDataMap.put("tc", noticeMapper.noticeGetTotalCount());

        return findDataMap;
    }

    // 게시물 전체 조회 요청 중간 처리 with searching
    public Map<String, Object> noticeFindAllService(Search search) {
        log.info("noticeFindAll service start");

        Map<String, Object> findDataMap = new HashMap<>();

        List<NoticeDTO> noticeDTOList = noticeMapper.noticeFindSearchAll(search);

        // 목록 중간 데이터 처리
        noticeProcessConverting(noticeDTOList);

        findDataMap.put("nList", noticeDTOList);
        findDataMap.put("tc", noticeMapper.noticeGetTotalSearchCount(search));

        return findDataMap;
    }

    private void noticeProcessConverting(List<NoticeDTO> noticeDTOList) {
        for (NoticeDTO n : noticeDTOList) {
            noticeConvertDateFormat(n);
            noticeSubStringTitle(n);
            noticeCheckNewArticle(n);
        }
    }

    // 신규 게시물 여부 처리
    private void noticeCheckNewArticle(NoticeDTO n) {
        // 게시물의 작성일자와 현재 시간을 대조

        // 게시물의 작성일자 가져오기
        long regDateTime = n.getNoticeRegDate().getTime();

        // 현재 시간 얻기 (밀리초)
        long nowTime = System.currentTimeMillis();

        // 현재 시간 - 작성 시간
        long diff = nowTime - regDateTime;

        // 신규 게시물 제한시간
        long limitTime = 60 * 5 * 1000;

        if (diff < limitTime) {
            n.setNoticeNewArticle(true);
        }
    }

    private void noticeConvertDateFormat(NoticeDTO n) {
        Date date = n.getNoticeRegDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
        n.setNoticePrettierDate(sdf.format(date));
    }

    private void noticeSubStringTitle(NoticeDTO n) {
        // 만약 글 제목이 10글자 이상이라면 10글자만 보여주고 나머지는 ... 처리
        String title = n.getNoticeTitle();
        if (title.length() > 10) {
            String subStr = title.substring(0, 10);
            n.setNoticeShortTitle(subStr + "...");
        } else {
            n.setNoticeShortTitle(title);
        }
    }

    // 게시물 상세 조회 요청 중간 처리
    @Transactional
    public NoticeDTO noticeFindOneService(Long noticeNo, HttpServletResponse response, HttpServletRequest request) {
        log.info("noticeFindOne service start - {}", noticeNo);
        NoticeDTO noticeDTO = noticeMapper.noticeFindOne(noticeNo);

        // 해당 게시물 번호에 해당하는 쿠키가 있는지 확인
        // 쿠키가 없으면 조회수를 상승시켜주고 쿠키를 만들어서 클라이언트에 전송
        makeViewCount(noticeNo, response, request);

        return noticeDTO;
    }

    private void makeViewCount(Long noticeNo, HttpServletResponse response, HttpServletRequest request) {
        // 쿠키 조회 - 해당 이름의 쿠키가 있으면 쿠키가 들어오고 없으면 null 이 들어옴
        Cookie foundCookie = WebUtils.getCookie(request, "n" + noticeNo);

        if (foundCookie == null) {
            noticeMapper.noticeUpViewCount(noticeNo);

            Cookie cookie = new Cookie("n" + noticeNo, String.valueOf(noticeNo)); // 쿠키 생성
            cookie.setMaxAge(60); // 쿠키 수명 설정
            cookie.setPath("/notice/noticeview"); // 쿠키 작동 범위

            response.addCookie(cookie); // 클라이언트에 쿠키 전송
        }
    }

    // 게시물 삭제 요청 중간 처리
    @Transactional
    public boolean noticeDeleteService(Long noticeNo) {
        log.info("noticeRemove service start - {}", noticeNo);

        // 원본 게시물 삭제
        boolean delete = noticeMapper.noticeDelete(noticeNo);
        return delete;
    }

    // 게시물 수정 요청 중간 처리
    public boolean noticeModifyService(NoticeDTO noticeDTO) {
        log.info("noticeModify service start - {}", noticeDTO);
        return noticeMapper.noticeModify(noticeDTO);
    }

    // 첨부파일 목록 가져오는 중간처리
    public List<String> getFiles(Long nno) {
        return noticeMapper.noticeFindFileNames(nno);
    }

    // 게시물 번호로 글쓴이 회원정보 가져오기


}
