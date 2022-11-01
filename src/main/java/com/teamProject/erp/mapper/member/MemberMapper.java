package com.teamProject.erp.mapper.member;

import com.teamProject.erp.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    int membercheck(Map<String, Object> checkmember);   //중복된 아이디 및 패스워드 여부확인
    boolean memberRegister(Member member);    //회원가입기능

    int memberidfind(Member member);       //아이디찾기페이지 해당정보존재여부반환

    List<Member> getmember(Member member);      //이름 직급으로 해당 리스트 가져오기

    String memberpwfind(Member member);

}
