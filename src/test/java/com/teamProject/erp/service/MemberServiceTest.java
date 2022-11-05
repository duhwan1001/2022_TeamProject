package com.teamProject.erp.service;

import com.teamProject.erp.dto.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    @Autowired private MemberService memberService;

    @Test
    @DisplayName("아이디찾기테스트")
    void idfind(){

        Member member= new Member();
        member.setUserId("홍길동");
        member.setUserDep("개발팀");

    }

}