package com.teamProject.erp.service;

import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.dto.FaqDTO;
import com.teamProject.erp.dto.FaqSearch;
import com.teamProject.erp.dto.Member;
import com.teamProject.erp.mapper.faq.FaqMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Log4j2
@RequiredArgsConstructor
public class FaqService {

    private final FaqMapper faqMapper;

    public boolean viewsave(FaqDTO faqDTO){             //게시물 등록(관리자 권한)
        return faqMapper.viewsave(faqDTO);
    }

//    public List<FaqDTO> viewlist(){                     // 게시물 전체 가져오기
//        List<FaqDTO> list = faqMapper.viewlist();
//
//        List<FaqDTO> faqlist = new ArrayList<>();
//
//        for (FaqDTO faqDTO : list){
//            SimpleDateFormat setregdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = faqDTO.getFaqRegdate();
//            String getdates = setregdate.format(date);
//
//            faqDTO.setStrRegdate(getdates);
//            faqlist.add(faqDTO);
//
//        }
//        return faqlist;
//    }

    public Map<String, Object> viewlist(FaqSearch faqSearch){

        Map<String, Object> listdata = new HashMap<>();
        // 게시물 전체 가져오기(검색조건 검색 키워드 입력시 수행하는 메서드)
        List<FaqDTO> list = faqMapper.viewlistsearch(faqSearch);
        List<FaqDTO> getlist = new ArrayList<>();

//        log.info("확인이요!");
        for (FaqDTO faqDTO : list){
            SimpleDateFormat setregdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = faqDTO.getFaqRegdate();
            String getdates = setregdate.format(date);

            faqDTO.setStrRegdate(getdates);
            getlist.add(faqDTO);
        }

        listdata.put("flist", getlist);
        Integer getpageno = faqMapper.faqCountTotal();
        listdata.put("pageno", getpageno);

        return listdata;
    }

    public FaqDTO viewdetaile(Integer faqno){               //게시물 번호로 해당 정보가져오기(관리자권한수행)
        faqMapper.faqviewcountup(faqno);

        FaqDTO faqDTO = faqMapper.viewdetaile(faqno);
        Date date = faqDTO.getFaqRegdate();
        SimpleDateFormat getregdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String setregdate =getregdate.format(date);
        faqDTO.setStrRegdate(setregdate);
        return faqDTO;
    }

    public boolean viewmodify(FaqDTO faqDTO){                //게시물 수정(관리자 권한)
        log.info("수정서비스에서 받은 아이디:{}", faqDTO.getUserUserId());
        log.info("수정서비스에서 받은 제목:{}", faqDTO.getFaqTitle());
        log.info("수정서비스에서 받은 내용:{}", faqDTO.getFaqContent());
        return faqMapper.viewmodify(faqDTO);
    }

    public boolean viewdelete(Integer faqno){
        return faqMapper.viewdelete(faqno);
    }

    public String getuserflag(String userId){
        return faqMapper.getuserflag(userId);
    }



}
