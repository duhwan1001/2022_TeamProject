package com.teamProject.erp.dto;

import lombok.*;

// import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {

    private int noticeNo;
    private String noticeTitle;
    private String noticeContent;
    private int noticeViewCount;
    private Date noticeRegDate;

    private String userId;
    private int fileNo;

    private String noticeShortTitle;
    private String noticePrettierDate;
    private boolean noticeNewArticle;

    private List<String> noticeFileNames;

/*
    public NoticeDTO(ResultSet rs) throws SQLException {
        this.noticeNo = rs.getLong("notice_no");
        this.title = rs.getString("notice_title");
        this.content = rs.getString("notice_content");
        this.viewCount = rs.getLong("notice_viewcount");
        this.regDate = rs.getTimestamp("notice_regdate");
    }

 */
}
