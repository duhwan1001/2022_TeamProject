package com.teamProject.erp.controller;

import com.teamProject.erp.dto.Member;
import com.teamProject.erp.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

@Controller
@Log4j2
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @RequestMapping(value="/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView logout(HttpServletRequest request) {
        log.info("logout function");
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/logout");
        return mv;
    }

    //로그인 페이지이동
    @RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
        return mv;
    }

    // 로그인 처리
    @RequestMapping("/signIn")
    public String signIn(@ModelAttribute Member mem, HttpServletRequest request, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        log.info("signIn 호출됨");
        log.info("id : {}, pw : {}", mem.getUserId(), mem.getUserPw());

        MessageDigest pw = MessageDigest.getInstance("SHA-512");
        pw.update(mem.getUserPw().getBytes("UTF-8"));
        byte[] getpw = pw.digest();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<getpw.length; i++){
            sb.append(Integer.toString((getpw[i] & 0xff) + 0x100, 16).substring(1));
        }

        String userpw = sb.toString();
        log.info(userpw);
        mem.setUserPw(userpw);


        int userInfo = memberService.checkLogin(mem);
        HttpSession session = request.getSession();



        if (userInfo != 0) {
            session.setMaxInactiveInterval(3600);
            session.setAttribute("userId", mem.getUserId());
            return "main/main";
        } else {
            return "/login";
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
    public String singup(Member member) throws Exception {
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
    @RequestMapping(value="/passwordfind/passfind", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<?> passwordfind(Member member) {

        System.out.println("아이디:"+ member.getUserId()+"\n이름:"+ member.getUserName());
        String getpassword = memberService.passwordfind(member);
        System.out.println("가져온 데이터:"+ getpassword);
        ModelAndView mv = new ModelAndView("");
        if (getpassword.equals("Y")){

            mv.addObject("getpassword", getpassword);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }else{
            System.out.println("여기까지 확인!!");
            mv.addObject("getpassword", getpassword);
            return new ResponseEntity<>("실패!!", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(value = "/passwordfind/pwfindpath", method = {RequestMethod.GET, RequestMethod.POST})
    public String pwfindpath(Model model, Member member) throws NoSuchAlgorithmException, UnsupportedEncodingException{
//        log.info("비밀번호:{}, 받은 데이터:{}", member.getUserPw(), pass);
        System.out.println("진입!");
        Random ranpw = new Random();
        int ranpassword = ranpw.nextInt(1000000);
        String password = Integer.toString(ranpassword);
//            log.info("평문화한 랜덤비번:{}", password);
        member.setUserPw(password);
        memberService.passwordUpdate(member);
        model.addAttribute("getpassword", password);
        return "login/passwordfindok";
    }

}