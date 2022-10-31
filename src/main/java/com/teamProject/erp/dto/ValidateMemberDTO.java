package com.teamProject.erp.dto;

import com.teamProject.erp.member.domain.Auth;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class ValidateMemberDTO {

    private String account;
    private Auth auth;
}
