package com.teamProject.erp.service;

import com.teamProject.erp.dto.MailDTO;
import com.teamProject.erp.mapper.mail.MailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class MailService {

    private final MailMapper mailMapper;

    public Map<String, Object> findAll() {
        log.info("mail findAll service");

        Map<String, Object> findDataMap = new HashMap<>();

        List<MailDTO> mailList = mailMapper.findAll();
        findDataMap.put("mList", mailList);

        return findDataMap;
    }

    public Map<String, Object> receivedMail(String userId) {
        log.info("mail receivedMail service 호출됨");

        Map<String, Object> findDataMap = new HashMap<>();

        List<MailDTO> mailList = mailMapper.receivedMail(userId);
        findDataMap.put("mList", mailList);

        return findDataMap;
    }

    public Map<String, Object> sendedMail(String userId) {
        log.info("mail sendedMail service 호출됨");

        Map<String, Object> findDataMap = new HashMap<>();

        List<MailDTO> mailList = mailMapper.sendedMail(userId);
        findDataMap.put("mList", mailList);

        return findDataMap;
    }

    public int sendMail(MailDTO mailDTO) {
        int check = mailMapper.sendMail(mailDTO);
        return check;
    }

    public MailDTO selectFind(int mailNo) {
        MailDTO info = mailMapper.selectFind(mailNo);
        return info;
    }
}
