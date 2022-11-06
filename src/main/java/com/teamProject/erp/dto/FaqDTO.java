package com.teamProject.erp.dto;

import lombok.*;

import java.util.Date;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FaqDTO {

    private Integer faqNo;
    private String faqTitle;
    private String faqContent;
    private Integer faqViewcount;
    private Date faqRegdate;
    private String userUserId;
    private String strRegdate;
}
