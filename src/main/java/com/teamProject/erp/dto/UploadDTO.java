package com.teamProject.erp.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class UploadDTO {
    private String nmae;
    private MultipartFile file;
    private int fileDiv;
}