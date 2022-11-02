package com.teamProject.erp.controller;

import com.teamProject.erp.common.Search.Search;
import com.teamProject.erp.service.MrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/main")
public class MrController {

    private final MrService mrservice;

    // 목록
    @GetMapping("/mrlist")
    public String MrList(@ModelAttribute("s")Search search, Model model){
        log.info("controller request /main/mrlist GET! - search: {}", search);

        Map<String, Object>
    }
}
