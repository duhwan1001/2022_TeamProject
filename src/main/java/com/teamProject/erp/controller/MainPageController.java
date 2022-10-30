package com.teamProject.erp.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class MainPageController {

//    @Autowired
//    private SampleService sampleService;
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

    @RequestMapping(value="/main", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView main() {
        log.info("main 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/main");
        return mv;
    }

    // 로그인하자마자 나오는 대시보드
    @RequestMapping(value="/main/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView dashboard() {
        log.info("main/dashboard 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/dashboard");
        return mv;
    }

    // 내 정보 수정
    @RequestMapping(value="/main/editinfo", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editInfo() {
        log.info("/main/editinfo 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/editinfo");
        return mv;
    }

    // 내가 쓴 글
    @RequestMapping(value="/main/mywrite", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mywrite() {
        log.info("/main/mywrite 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/mywrite");
        return mv;
    }

    @RequestMapping(value="/main/todo", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView todo() {
        log.info("/main/todo 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/todo");
        return mv;
    }

    // 공지사항
    @RequestMapping(value="/main/notice", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView notice() {
        log.info("/main/notice 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/notice");
        return mv;
    }

    // 자유게시판
//    @RequestMapping(value="/main/mainboard", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mainboard() {
//        log.info("/main/mainboard 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("main/mainboard");
//        return mv;
//    }

    // 자료 공유
    @RequestMapping(value="/main/sharedata", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView shareData() {
        log.info("/main/sharedata 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/sharedata");
        return mv;
    }

    // 사내 일정
    @RequestMapping(value="/main/cocalender", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView coCalender() {
        log.info("/main/cocalender 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/coCalender");
        return mv;
    }

    // Q&A
    @RequestMapping(value="/main/qna", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView qna() {
        log.info("/main/qna 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/qna");
        return mv;
    }

    // Q&A
    @RequestMapping(value="/main/faq", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView faq() {
        log.info("/main/faq 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/faq");
        return mv;
    }


}