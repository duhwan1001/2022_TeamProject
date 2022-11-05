package com.teamProject.erp.mapper.faq;

import com.teamProject.erp.dto.FaqDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FaqMapperTest {

    @Autowired private FaqMapper faqMapper;

    @Test
    @DisplayName("값입력확인")
    void saves(){

        FaqDTO faqDTO = new FaqDTO();
        faqDTO.setFaqTitle("제목2");
        faqDTO.setFaqContent("입력내용2");

        faqMapper.viewsave(faqDTO);
    }

    @Test
    @DisplayName("번호로 값가져오기")
    void viewdetail(){
        FaqDTO faqDTO = faqMapper.viewdetaile(4);


        assertEquals(4, faqDTO.getFaqNo());
        assertEquals("질문합니다.", faqDTO.getFaqContent());

    }

}