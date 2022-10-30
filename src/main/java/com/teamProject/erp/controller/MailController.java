package com.teamProject.erp.controller;

import com.teamProject.erp.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
//
//    @RequestMapping(value="/index", method = {RequestMethod.POST, RequestMethod.GET})
//    public String index(HttpServletRequest request, Model model) {
//
//        System.out.println("인덱스 페이지 호출");
//        String test = sampleService.selectTest();
//        System.out.println("조회 테스트 : "+test);
//        model.addAttribute("test", "테스트");
//        return "index";
//    }

    @RequestMapping(value="/mail/{type}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView main(@PathVariable String type, HttpServletRequest req) {
        log.info("mail mainpage 호출 됨");
        Map<String, Object> mailMap = new HashMap<>();
        String userId = req.getParameter("sessionId");

        if(type.equals("send"))
        {
            mailMap = mailService.sendedMail(userId);
        } 
        else if (type.equals("receive"))
        {
            mailMap = mailService.receivedMail(userId);
        }

        log.info("return data - {}", mailMap);
        ModelAndView mv = new ModelAndView();
        mv.addObject("mList", mailMap.get("mList"));
        mv.setViewName("mail/main");
        return mv;
    }

}