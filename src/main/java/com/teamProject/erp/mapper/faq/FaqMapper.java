package com.teamProject.erp.mapper.faq;

import com.teamProject.erp.dto.FaqDTO;
import com.teamProject.erp.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FaqMapper {

    boolean viewsave(FaqDTO faqDTO);

    List<FaqDTO> viewlist();

    FaqDTO viewdetaile(Integer faqno);

    boolean viewmodify(FaqDTO faqDTO);

    boolean viewdelete(Integer faqNo);

    String getuserflag(String userid);

    void faqviewcountup(Integer faqno);

}
