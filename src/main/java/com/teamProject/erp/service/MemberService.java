package com.teamProject.erp.service;

import com.teamProject.erp.dto.MemberDTO;
import com.teamProject.erp.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    public int checkLogin(MemberDTO mem) {
        log.info("member checkLogin service");
        int check = memberMapper.checkLogin(mem);
        log.info(check);
        return check;
    }
}
