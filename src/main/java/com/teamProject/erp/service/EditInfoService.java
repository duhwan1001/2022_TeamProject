package com.teamProject.erp.service;

import com.teamProject.erp.dto.Member;
import com.teamProject.erp.dto.MemberDTO;
import com.teamProject.erp.mapper.editInfo.EditInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class EditInfoService {

    private final EditInfoMapper editInfoMapper;

    public Member getUserInfo(String userId) {
        log.info("editInfo findAll service");

        Member userInfo = editInfoMapper.getUserInfo(userId);
        log.info("userInfo from DB : " + userInfo);

        return userInfo;
    }

    public boolean editUserInfo(Member member) {
        log.info("editInfo edit service");

        boolean check = editInfoMapper.editUserInfo(member);

        return check;
    }
}
