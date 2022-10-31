package com.teamProject.erp.mapper.notice;

import com.teamProject.erp.dto.NoticeDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeMapperTest {

    @Autowired
    NoticeMapper mapper;

    @Test
    @DisplayName("100개의 게시물을 삽입해야 한다.")
    void bulkInsert() {
        NoticeDTO noticeDTO;
        for (int i = 0; i <= 300; i++) {
            noticeDTO = new NoticeDTO();
            noticeDTO.setNoticeTitle("제목" + i);
            noticeDTO.setNoticeContent("내용이다" + i);
        }
    }
}