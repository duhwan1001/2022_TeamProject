package com.teamProject.erp.mapper.member;

import com.teamProject.erp.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {

    int membercheck(Map<String, Object> checkmember);
    boolean memberRegister(Member member);

}
