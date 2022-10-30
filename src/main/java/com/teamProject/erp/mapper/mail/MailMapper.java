package com.teamProject.erp.mapper.mail;

import com.teamProject.erp.dto.MailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MailMapper {

    public List<MailDTO> findAll();

    List<MailDTO> receivedMail(String type);

    List<MailDTO> sendedMail(String userId);
}
