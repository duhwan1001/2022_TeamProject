package com.teamProject.erp.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class MeetingDTO {

    private Long mrNo; //글번호
    private String mrUsers; //예약자명
    private Date mrTime; //사용시간
    private String mrTitle; //회의실 명
    private String mrContent; //회의실 설명

    private String userId; //사용자 ID
    private List<String> fileNo; // 첨부파일들의 이름 목록

    //커스텀 데이터 필드
    private String shortTitle; //줄임 제목
    private String prettierDate; // 변경된 날짜포맷 문자열
    private boolean mewArticle; // 신규 게시물 여부
}
