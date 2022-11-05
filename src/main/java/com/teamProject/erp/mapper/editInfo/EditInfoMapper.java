package com.teamProject.erp.mapper.editInfo;

import com.teamProject.erp.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EditInfoMapper {

    Member getUserInfo(String userId);

    boolean editUserInfo(Member member);
}
