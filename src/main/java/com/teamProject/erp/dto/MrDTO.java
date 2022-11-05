package com.teamProject.erp.dto;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class MrDTO {

    private int mrNo; //글번호
    private String mrTitle; //회의실 명
    private int mrMax; // 입장 가능 인원
    private String mrUsers; //예약자명
    private int mrTime; //사용시간
    private String mrContent; //회의실 설명
    private Date mrRegDate; // 작성 일자

    private String userId; //사용자 ID
    private int fileNo; // 파일 번호

    private String mrShortTitle;
    private String mrPrettierDate;
    private boolean mrNewArticle;

    private List<String> mrFileNames; // 첨부파일들의 이름 목록

    public MrDTO(ResultSet rs) throws SQLException {
        this.mrNo = rs.getInt("mr_no");
        this.mrTitle = rs.getString("mr_title");
        this.mrMax = rs.getInt("mr_max");
        this.mrUsers = rs.getString("mr_users");
        this.mrTime = rs.getInt("mr_time");
        this.mrContent = rs.getString("mr_content");
        this.mrRegDate = rs.getDate("mr_regdate");
    }
}
