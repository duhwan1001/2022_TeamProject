package com.teamProject.erp.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class MeetingRoomController {
    // 회의실 메인
    @RequestMapping(value="/main/mrmain", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView meetingRoom() {
        log.info("/main/mrmain 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/mrmain");
        return mv;
    }

    @RequestMapping(value="/main/mrdetail", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mrDetail() {
        log.info("/main/mrdetail 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("MRoom/mrDetail");
        return mv;
    }
    @RequestMapping(value="/main/mrlist", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mrList() {
        log.info("/main/mrlist 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("MRoom/mrList");
        return mv;
    }
    @RequestMapping(value="/mrlist/mrregistration", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mrRegistration() {
        log.info("/main/mrregistration 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("MRoom/mrRegistration");
        return mv;
    }
    @RequestMapping(value="/mrdetail/mrupdate", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mrUpdate() {
        log.info("/main/mrupdate 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("MRoom/mrUpdate");
        return mv;
    }
}
