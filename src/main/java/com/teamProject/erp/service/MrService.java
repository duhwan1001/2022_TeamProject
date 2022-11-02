package com.teamProject.erp.service;

import com.teamProject.erp.mapper.mroom.MrMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MrService {
    //private final 한 세트 @RequiredArgsConstructor이거를 안해주면 생성자 생성이 안됨.
    private final MrMapper mrmapper;
}
