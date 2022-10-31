package com.teamProject.erp.service;

import com.teamProject.erp.dto.Member;
import com.teamProject.erp.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    //실시간 아이디 이메일 체크
    public boolean checkSignUpValue(String type, String value) {
//        log.info("비지니스전달받은값확인 type={}", type);
        Map<String, Object> checkMap = new HashMap<>();
        checkMap.put("type", type);
        checkMap.put("value", value);
        boolean usercheck = memberMapper.membercheck(checkMap) ==1;
//        log.info("비교한값확인: "+ usercheck);
        return usercheck;
    }

    //회원가입기능처리
    public boolean memberResister(Member member){

        SimpleDateFormat now = new SimpleDateFormat("yy-MM-dd");

        Date date = new java.sql.Date(System.currentTimeMillis());      //현제시간
       // log.info("지금시간:{}", date.toString());

        member.setUserRegdate(date);

        Random rand = new Random();                                 //사원번호6자리 랜덤생성
        int user_no = rand.nextInt(888888) + 111111;
        String setuser_no = Integer.toString(user_no);
        member.setUserNo(setuser_no);

        if (member.getUserPw().equals("erpadmin")){                     //(임시) pw에 따라서 erpadmin이면 1 아니면 0 관리자 유무결정
            member.setUserFlag("1");
        }else{
            member.setUserFlag("0");
        }

        return memberMapper.memberRegister(member);

    }

}
