package com.teamProject.erp.dto;

import lombok.*;

import java.util.Date;

@Setter @Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String userId;   //사원 아이디
    private String userPw;   //사원 비밀번호
    private String userName;  //사원 이름
    private String userHp;    //사원 전화번호
    private String userAddr;  //사원 주소
    private String userAddr2;  //사원 상세주소
    private String userDep;    //사원 부서
    private String userRank;   //사원 직급
    private Date userRegdate; //현재날짜
    private String userNo; //사원번호
    private String userFlag; //사원구분
    private int userpathNo;  //사원번호생성후전달
}
