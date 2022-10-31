package com.teamProject.erp.controller;

import com.teamProject.erp.dto.Member;
import com.teamProject.erp.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

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

    @RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login() {
        log.info("login page 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
        return mv;
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
    public String membership(Member member) {
        log.info("membership page 호출 됨");
        return "/login/membership";
    }

    //아이디 이메일 중복확인
    @GetMapping("/membership/check")
    @ResponseBody
    public ResponseEntity<Boolean> idcheck(String type, String value){
        log.info("전달받은값:type={}&value={}", type, value);
        boolean getdata =  memberService.checkSignUpValue(type, value);
        return new ResponseEntity<>(getdata, HttpStatus.OK);
    }


    // 회원가입 처리기능
    @RequestMapping("/membership/sing-up")
    public String singup(Member member){
        log.info("회원가입 받은 데이터id={}", member.getUserId());
        return memberService.memberResister(member) ? "login/login": "login/membership";
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