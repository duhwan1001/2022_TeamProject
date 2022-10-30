package com.teamProject.erp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
@AllArgsConstructor
public class Member {


    private String user_id;   //사원 아이디
    private String user_pw;   //사원 비밀번호
    private String user_name;  //사원 이름
    private String user_hp;    //사원 전화번호
    private String user_addr;  //사원 주소
    private String user_addr2;  //사원 상세주소
    private String user_dep;    //사원 부서
    private String user_rank;   //사원 직급

}
