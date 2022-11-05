package com.teamProject.erp.service;

import com.teamProject.erp.dto.FaqDTO;
import com.teamProject.erp.dto.Member;
import com.teamProject.erp.mapper.faq.FaqMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class FaqService {

    private final FaqMapper faqMapper;

    public boolean viewsave(FaqDTO faqDTO){             //게시물 등록(관리자 권한)
        return faqMapper.viewsave(faqDTO);
    }

    public List<FaqDTO> viewlist(){                     // 게시물 전체 가져오기
        List<FaqDTO> list = faqMapper.viewlist();
        return list;
    }

    public FaqDTO viewdetaile(Integer faqno){               //게시물 번호로 해당 정보가져오기(관리자권한)
        faqMapper.faqviewcountup(faqno);
        return faqMapper.viewdetaile(faqno);
    }

    public boolean viewmodify(FaqDTO faqDTO){                //게시물 수정(관리자 권한)
        log.info("게시물수정로직");
        return faqMapper.viewmodify(faqDTO);
    }

    public boolean viewdelete(Integer faqno){
        log.info("게시물삭제 로직수행");
        return faqMapper.viewdelete(faqno);
    }

    public String getuserflag(String userId){
        return faqMapper.getuserflag(userId);
    }



}
