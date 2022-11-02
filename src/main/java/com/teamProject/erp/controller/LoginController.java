package com.teamProject.erp.controller;

import com.teamProject.erp.dto.MemberDTO;
import com.teamProject.erp.service.MemberService;
import com.teamProject.erp.dto.Member;
import com.teamProject.erp.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    //로그인 페이지이동
    @RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login() {
//        log.info("login page 호출 됨");
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
    public String idfindpath() {
       // log.info("idfind page 호출 됨");
        return "login/Idfind";
    }

    //아이디 찾기 기능
    @RequestMapping(value = "/idfind/checkfind", method = {RequestMethod.GET, RequestMethod.POST})
    public String idfind(Member member, Model model){
      //  log.info("받은값확인 name={}, dep={}", member.getUserName(), member.getUserDep());
        List<Member> idlist = memberService.idfind(member);
        log.info("컨트롤러 반환값확인!");
        model.addAttribute("member", idlist);
        model.addAttribute("setmember", member);
        return idlist!=null ? "login/idfindok" : "login/idfindno";
    }

    //비밀번호 찾기 기능
//    @PostMapping("/passwordfind/pwfind")
//    public String passfind(Member member, Model model){
//        log.info("받은값확인 name={}, dep={}", member.getUserName(), member.getUserDep());
//        return !memberService.passwordfind(member).equals("N") ? "login/passwordfindok" : "login/passwordfindno";
//    }

    //회원가입페이지 이동
    @RequestMapping(value="/membership", method = {RequestMethod.GET, RequestMethod.POST})
    public String membership(Member member) {
//        log.info("membership page 호출 됨");
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
    public String singup(Member member) {
//        log.info("회원가입 받은 데이터id={}", member.getUserId());
        return memberService.memberResister(member) ? "redirect:/":"login/membership";
    }

    //비번찾기 페이지이동
    @RequestMapping(value="/passwordfind", method = {RequestMethod.GET, RequestMethod.POST})
    public String passwordfindpath() {
//        log.info("passwordfind page 호출 됨");
        return "login/passwordfind";
    }

    //비번찾기 기능구현
    @PostMapping("/passwordfind/passfind")
    public String passwordfind(Member member, Model model){

        String getmembers = memberService.passwordfind(member);
        model.addAttribute("memberpw", getmembers);
        model.addAttribute("member", member);
        return !getmembers.equals("N") ? "login/passwordfindok":"login/passwordfindno";
    }

}