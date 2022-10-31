package com.teamProject.erp.mapper.member;

import com.teamProject.erp.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public int checkLogin(MemberDTO mem);
}
