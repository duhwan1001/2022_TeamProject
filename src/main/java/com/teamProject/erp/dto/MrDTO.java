package com.teamProject.erp.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class MrDTO {

    private int mrNo; //글번호
    private String mrUsers; //예약자명
    private Date mrTime; //사용시간
    private String mrTitle; //회의실 명
    private String mrContent; //회의실 설명
    private String mrWriter;

    private String userId; //사용자 ID
    private int fileNo; // 파일 번호
    private List<String> filenames; // 첨부파일들의 이름 목록
}
