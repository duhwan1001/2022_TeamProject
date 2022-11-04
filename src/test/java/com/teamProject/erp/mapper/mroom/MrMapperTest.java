package com.teamProject.erp.mapper.mroom;

import com.teamProject.erp.dto.MrDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MrMapperTest {

    @Autowired
    MrMapper mapper;

    @Test
    @DisplayName("50개의 게시물을 삽입해야 한다.")
    void bulkInsert() {
        MrDTO mrDTO;
        for (int i = 1; i <= 50; i++) {
            mrDTO = new MrDTO();
            mrDTO.setMrTitle("제목" + i);
            mrDTO.setMrContent("내용" + i);
            mapper.mrInsert(mrDTO);
        }
    }

}