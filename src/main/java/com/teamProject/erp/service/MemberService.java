package com.teamProject.erp.service;

import com.teamProject.erp.dto.Member;
import com.teamProject.erp.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
  //  private final BCryptPasswordEncoder encoder;

    //로그인 처리
    public int checkLogin(Member mem) {
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
    public boolean memberResister(Member member) throws Exception{

        if (member.getUserPw().equals("erpadmin")){
            log.info("관리자확인");
            member.setUserFlag("관리자");
        }else{
            log.info("일반확인");
            member.setUserFlag("일반");
        }

        MessageDigest pw = MessageDigest.getInstance("SHA-512");
        pw.update(member.getUserPw().getBytes("UTF-8"));
        byte[] getpw = pw.digest();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<getpw.length; i++){
            sb.append(Integer.toString((getpw[i] & 0xff) + 0x100, 16).substring(1));
        }
        String userpw = sb.toString();
        member.setUserPw(userpw);

        Date date = new java.sql.Date(System.currentTimeMillis());      //현재시간가져오기
        member.setUserRegdate(date);

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
        return password;
    }

    public void passwordUpdate(Member member) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest pw = MessageDigest.getInstance("SHA-512");
        pw.update(member.getUserPw().getBytes());
        byte [] getpw = pw.digest();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<getpw.length; i++){
            sb.append(Integer.toString((getpw[i] & 0xff) + 0x100,16).substring(1));
        }
        String password = sb.toString();
        member.setUserPw(password);
        memberMapper.passwordUpdate(member);
    }
}
