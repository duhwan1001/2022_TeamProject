package com.teamProject.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
@AllArgsConstructor
public class MemberDTO {
    private String userId;   //사원 아이디
    private String userPw;   //사원 비밀번호
    private String userName;  //사원 이름
    private String userHp;    //사원 전화번호
    private String userAddr;  //사원 주소
    private String userAddr2;  //사원 상세주소
    private String userDep;    //사원 부서
    private String userRank;   //사원 직급

    private String filePath; // 파일 경로
}
