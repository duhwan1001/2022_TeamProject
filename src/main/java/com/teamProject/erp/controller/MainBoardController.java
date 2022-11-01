package com.teamProject.erp.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class MainBoardController {
    // 자유게시판
    @RequestMapping(value = "/main/mainboard", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mainboard() {
        log.info("/main/mainboard 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/mainboard");
        return mv;
    }

    @RequestMapping(value = "/mainboard/writeboard", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView wirteboard() {
        log.info("/main/writeboard 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/mainboard/writeboard");
        return mv;
    }

    @RequestMapping(value = "/mainboard/readboard", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView readboard() {
        log.info("/main/readboard 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/mainboard/readboard");
        return mv;

    }

    @RequestMapping(value = "/mainboard/reviseboard", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView reviseboard() {
        log.info("/main/reviseboard 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/mainboard/reviseboard");
        return mv;
    }

}




