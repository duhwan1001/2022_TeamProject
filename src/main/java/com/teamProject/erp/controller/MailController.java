package com.teamProject.erp.controller;

import com.teamProject.erp.dto.MailDTO;
import com.teamProject.erp.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @RequestMapping(value="/mail/{type}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView main(@PathVariable String type, HttpServletRequest req) {
        log.info("mail mainpage 호출 됨");
        Map<String, Object> mailMap = new HashMap<>();
        HttpSession session = req.getSession();

        String userId = (String) session.getAttribute("userId");

        if (type.equals("send")) {
            mailMap = mailService.sendedMail(userId);
        } else if (type.equals("receive")) {
            mailMap = mailService.receivedMail(userId);
        }

        log.info("return data - {}", mailMap);
        ModelAndView mv = new ModelAndView();
        mv.addObject("mList", mailMap.get("mList"));
        mv.setViewName("mail/main");
        return mv;
    }

    @RequestMapping(value="/mailForm", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mailForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mail/mailForm");
        return mv;
    }
    @RequestMapping(value="/mailSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mailSend(MailDTO mailDTO, HttpServletRequest request) {
        log.info("mail mainpage 호출 됨");
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        mailDTO.setMailSender(userId);

        int mailInfo = mailService.sendMail(mailDTO);

        mv.setViewName("mail/mailSuccess");
        return mv;
    }

    @RequestMapping(value="/mailDetail/{mailNo}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mailSend(@PathVariable int mailNo, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        MailDTO mailInfo = mailService.selectFind(mailNo);

        mv.addObject("info", mailInfo);
        mv.setViewName("mail/mailDetail");
        return mv;
    }

}