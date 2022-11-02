package com.teamProject.erp.service;

import com.teamProject.erp.dto.MemberDTO;
import com.teamProject.erp.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import com.teamProject.erp.dto.Member;
import com.teamProject.erp.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import com.teamProject.erp.dto.MemberDTO;
import com.teamProject.erp.mapper.member.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
  //  private final BCryptPasswordEncoder encoder;

    //로그인 처리
    public int checkLogin(MemberDTO mem) {
        log.info("member checkLogin service");
        int check = memberMapper.checkLogin(mem);
        log.info(check);
        return check;
    }

    //실시간 아이디 이메일 체크
    public boolean checkSignUpValue(String type, String value) {

        Map<String, Object> checkMap = new HashMap<>();
        checkMap.put("type", type);
        checkMap.put("value", value);
        boolean usercheck = memberMapper.membercheck(checkMap) ==1;

        return usercheck;
    }

    //회원가입기능처리
    public boolean memberResister(Member member) {

   //     member.setUserPw(encoder.encode(member.getUserPw()));

        log.info("사원번호초기값:{}", member.getUserpathNo());
        Date date = new java.sql.Date(System.currentTimeMillis());      //현재시간가져오기
        member.setUserRegdate(date);

//        member.setUserpathNo(1);
//        int setuserno = member.getUserpathNo();
//        log.info("사원번호초기생서:{}", member.getUserpathNo());
//
//        String setuser_no = Integer.toString(member.getUserpathNo());
//        member.setUserNo(setuser_no);
//
//        int nocheck = memberMapper.usernocheck(member);
//        if (nocheck ==0 ){
//            log.info("디비로직수행결과:{}", member.getUserpathNo());
//            member.setUserNo(Integer.toString(setuserno));
//        }else{
//            log.info("디비수행 초기");
//            String getuserno = memberMapper.getuserno(member);
//            int pathuserno = Integer.parseInt(getuserno);
//
//            int totaluser_no = setuserno+pathuserno;
//            member.setUserNo(Integer.toString(totaluser_no));
//        }

        if (member.getUserPw().equals("erpadmin")){
            member.setUserFlag("관리자");
        }else{
            member.setUserFlag("일반");
        }
        return memberMapper.memberRegister(member);

    }

    //아이디찾기
    public List<Member> idfind(Member member) {

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
