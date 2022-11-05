package com.teamProject.erp.mapper.member;

import com.teamProject.erp.dto.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {

    @Autowired private MemberMapper memberMapper;

    @Test
    @DisplayName("회원값확인")
    void idfind(){
        Member member = new Member();
        member.setUserName("홍길동");
        member.setUserDep("개발팀");

        assertEquals(2, memberMapper.memberidfind(member));

    }

    @Test
    @DisplayName("회원리스트")
    void getmember(){
        Member member = new Member();
        member.setUserName("홍길동");
        member.setUserDep("개발팀");
        List<Member> memberList = memberMapper.getmember(member);
        for (Member members : memberList){
            System.out.println(members.toString());
        }
    }


}