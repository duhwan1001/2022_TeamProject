package com.teamProject.erp.dto;

import lombok.*;

import java.sql.Date;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class MailDTO {

    private int     mailNo;
    private String  mailContent;
    private String  mailTitle;
    private String  mailReceiver;
    private String  mailSender;
    private int     mailFlag;
    private Date    mailRegdate;

    private String  userId;
    private int     fileNo;
}
