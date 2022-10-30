package com.teamProject.erp.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class NoticeController {

//    공지사항 세부
    @RequestMapping(value="/notice/noticeview", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView noticeview() {
        log.info("/main/noticeview 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notice/noticeview");
        return mv;
    }

//    공지사항 등록
    @RequestMapping(value="/main/noticewrite", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView noticewrite() {
        log.info("/main/noticewrite 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notice/noticewrite");
        return mv;
    }

//    공지사항 수정
    @RequestMapping(value="/noticeview/noticemodify", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView noticemodify() {
        log.info("/main/noticemodify 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notice/noticemodify");
        return mv;
    }

}
