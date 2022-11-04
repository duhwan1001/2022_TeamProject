package com.teamProject.erp.service;

import com.teamProject.erp.common.Search.Search;
import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.dto.MrDTO;
import com.teamProject.erp.dto.ValidateMemberDTO;
import com.teamProject.erp.mapper.mroom.MrMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.WebUtils;

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
public class MrService {
    //private final 한 세트 @RequiredArgsConstructor이거를 안해주면 생성자 생성이 안됨.
    private final MrMapper mrMapper;

    @Transactional
    public boolean mrInsertService(MrDTO mrDTO) {
        log.info("mrInsert Service start - {}", mrDTO);

        // 회의실 내용 DB에 저장
        boolean flag = mrMapper.mrInsert(mrDTO);

//        List<String> fileNames = mrDTO.getMrFileNames();
//        if (fileNames != null && fileNames.size() > 0) {
//            for (String fileName : fileNames) {
//                //첨부파일 내용 DB에 저장
//                mrMapper.mrAddFile(fileName);
//            }
//        }
        return flag;
    }

    // 게시물 전체 조회 요청 중간 처리
    public List<MrDTO> mrFindAllService() {
        log.info("mrFindAll service start");
        List<MrDTO> mrDTOList = mrMapper.mrFindAll();

        // 목록 중간 데이터처리
        mrProcessConverting(mrDTOList);

        return mrDTOList;
    }

    //게시물 전체 조회 요청 중간 처리 with paging
    public Map<String, Object> mrFindAllService(Page page) {
        log.info("mrFindAll service start");

        Map<String, Object> findDataMap = new HashMap<>();

        List<MrDTO> mrDTOList = mrMapper.mrFindAll(page);

        //목록 중간 데이터 처리
        mrProcessConverting(mrDTOList);

        findDataMap.put("mList", mrDTOList);
        findDataMap.put("tc", mrMapper.mrGetTotalCount());

        return findDataMap;
    }

    // 게시물 전체 조회 요청 중간 처리 with searching
    public Map<String, Object> mrFindAllService(Search search) {
        log.info("mrFindAll service start");

        Map<String, Object> findDataMap = new HashMap<>();

        List<MrDTO> mrDTOList = mrMapper.mrFindSearchAll(search);

        //목록 중간 데이터 처리
        mrProcessConverting(mrDTOList);

        findDataMap.put("mList", mrDTOList);
        findDataMap.put("tc", mrMapper.mrGetTotalSearchCount(search));

        return findDataMap;
    }

    private void mrProcessConverting(List<MrDTO> mrDTOList) {
        for (MrDTO m : mrDTOList) {
            mrConvertDateFormat(m);
            mrSubStringTitle(m);
            mrCheckNewArticle(m);
        }
    }

    // 신규 게시물 여부 처리
    private void mrCheckNewArticle(MrDTO m) {
        // 게시물의 작성일자 가져오기
        long regDateTime = m.getMrRegDate().getTime();

        // 현재 시간 얻기 (밀리초)
        long nowTime = System.currentTimeMillis();

        // 현재 시간 - 작성 시간
        long diff = nowTime = regDateTime;

        // 신규 게시물 제한시간
        long limitTime = 60 * 5 * 1000;

        if (diff < limitTime) {
            m.setMrNewArticle(true);
        }
    }

    private void mrConvertDateFormat(MrDTO m) {
        Date date = m.getMrRegDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
        m.setMrPrettierDate(sdf.format(date));
    }

    private void mrSubStringTitle(MrDTO m) {
        // 만약 글 제목이 10글자 이상이라면 10 글자만 보여주고 나머지는 ... 처리
        String title = m.getMrTitle();
        if (title.length() > 10) {
            String subStr = title.substring(0, 10);
            m.setMrShortTitle(subStr + "...");
        } else {
            m.setMrShortTitle(title);
        }
    }

//    // 게시물 상세 조회 요청 중간 처리
    @Transactional
    public MrDTO mrFindOneService(Long mrNo) {
        log.info("mrFindOne service start - {}", mrNo);
        MrDTO mrDTO = mrMapper.mrFindOne(mrNo);

        return mrDTO;
    }

    // 게시물 삭제 요청 중간 처리
    @Transactional
    public boolean mrDeleteService(Long mrNo) {
        log.info("mrRemove service start - {}", mrNo);

        // 원본 게시물 삭제
        boolean delete = mrMapper.mrDelete(mrNo);
        return delete;
    }

    // 게시물 수정 요청 중간 처리
    public boolean mrModifyService(MrDTO mrDTO) {
        log.info("mrModify service start - {}", mrDTO);
        return mrMapper.mrModify(mrDTO);
    }

    // 첨부파일 목록 가져오는 중간 처리
    public List<String> getFiles(Long mno) { return mrMapper.mrFindFileNames(mno); }

    // 게시글 번호로 글쓴이 회원정보 가져오기
    public ValidateMemberDTO getMember(Long mrNo) {
        return mrMapper.findMemberByMrNo(mrNo);
    }
}
