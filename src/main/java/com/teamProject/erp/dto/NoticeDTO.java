package com.teamProject.erp.dto;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Setter @Getter @ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class NoticeDTO {

    private Integer noticeNo;
//    private String noticeWriter;
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


    public NoticeDTO(ResultSet rs) throws SQLException {
        this.noticeNo = rs.getInt("notice_no");
        this.noticeTitle = rs.getString("notice_title");
        this.noticeContent = rs.getString("notice_content");
        this.noticeViewCount = rs.getInt("notice_viewcount");
        this.noticeRegDate = rs.getTimestamp("notice_regdate");
    }
}
