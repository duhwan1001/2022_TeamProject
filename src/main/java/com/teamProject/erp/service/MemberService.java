package com.teamProject.erp.service;

import com.teamProject.erp.dto.Member;
import com.teamProject.erp.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    //private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //실시간 아이디 이메일 체크
    public boolean checkSignUpValue(String type, String value) {

        Map<String, Object> checkMap = new HashMap<>();
        checkMap.put("type", type);
        checkMap.put("value", value);
        boolean usercheck = memberMapper.membercheck(checkMap) ==1;

        return usercheck;
    }

    //회원가입기능처리
    public boolean memberResister(Member member){



        Date date = new java.sql.Date(System.currentTimeMillis());      //현재시간가져오기


        member.setUserRegdate(date);

        Random rand = new Random();                                 //사원번호6자리 랜덤생성
        int user_no = rand.nextInt(888888) + 111111;
        String setuser_no = Integer.toString(user_no);
        member.setUserNo(setuser_no);

        if (member.getUserPw().equals("erpadmin")){
            member.setUserFlag("1");
        }else{
            member.setUserFlag("0");
        }
        return memberMapper.memberRegister(member);

    }

    public List<Member> idfind(Member member) {                     //아이디찾기

        int idsu = memberMapper.memberidfind(member);
        if (idsu >= 1){
    //        log.info("id 확인!:{}", idsu);
            return memberMapper.getmember(member);
        }else{
   //         log.info("id 확인!:{}", idsu);
            return null;
        }
    }

    //비번찾기 기능구현
    public String passwordfind(Member member){
        String password = memberMapper.memberpwfind(member);
        if (password != null){
            log.info("받은비번:{}", password);
            return password;
        }else{
            return "N";
        }
    }

}
