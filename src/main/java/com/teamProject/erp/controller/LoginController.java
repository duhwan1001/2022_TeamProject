package com.teamProject.erp.controller;

import com.teamProject.erp.dto.MemberDTO;
import com.teamProject.erp.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequiredArgsConstructor
public class LoginController {

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

    private final MemberService memberService;

    @RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login() {
        log.info("login page 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
        return mv;
    }

    // 로그인 처리
    @RequestMapping("/signIn")
    public String signIn(@ModelAttribute MemberDTO mem, HttpServletRequest request) {
        log.info("signIn 호출됨");
        String id = request.getParameter("userId");
        String pw = request.getParameter("userPw");

        log.info("id : {}, pw : {}", id, pw);

        mem.setUserId(id);
        mem.setUserPw(pw);

        int userInfo = memberService.checkLogin(mem);
        HttpSession session = request.getSession();

        if (userInfo != 0) {
            session.setAttribute("userId", id);
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }

    //아이디 찾기페이지이동
    @RequestMapping(value="/idfind", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView idfind() {
        log.info("idfind page 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/Idfind");
        return mv;
    }

    //회원가입페이지 이동
    @RequestMapping(value="/membership", method = {RequestMethod.GET, RequestMethod.POST})
    public String membership(MemberDTO memberDTO) {
        log.info("membership page 호출 됨");
        return "/login/membership";
    }

    //아이디 이메일 중복확인
    @GetMapping("/membership/check")
    @ResponseBody
    public String idcheck(String type, String value){
        log.info("전달받은값:type={}&value={}", type, value);
        return "login/membership";
    }


    // 회원가입 처리기능
    @RequestMapping("/membership/sing-up")
    public String singup(MemberDTO memberDTO){
        log.info("회원가입 받은 데이터: {}", memberDTO);
        return "membership";
    }

    //비번찾기
    @RequestMapping(value="/passwordfind", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView passwordfind() {
        log.info("passwordfind page 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/passwordfind");
        return mv;
    }


}