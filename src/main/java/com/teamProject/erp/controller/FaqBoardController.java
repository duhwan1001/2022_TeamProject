package com.teamProject.erp.controller;

import com.teamProject.erp.dto.FaqDTO;
import com.teamProject.erp.service.FaqService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Controller
@Log4j2
@RequiredArgsConstructor
//@AllArgsConstructor
public class FaqBoardController {

    private final FaqService faqService;
    private HttpSession session;
//    private HttpSession session;

    @RequestMapping("/main/writer")             //글쓰기 화면 이동
    public String writer(FaqDTO faqDTO, Model model){
        log.info("받은 플래그:{}", faqDTO.getUserflag());
        model.addAttribute("list", faqDTO);
        return "main/faqwriter";
    }

    @RequestMapping("/main/faqdetaile")
    public String detaile(Model model, FaqDTO faqDTO){             //특정게시물조회(모두가능

        FaqDTO list = faqService.viewdetaile(faqDTO.getFaqNo());
        log.info("DB에서 가져온 유저아이디:{}", list.getUserUserId());
        list.setUserflag(faqDTO.getUserflag());
        list.setUserUserId(faqDTO.getUserUserId());
// 로그인시 사용자 userID 가져와야함
 //       String getuser = faqService.getuserflag(list.getUserUserId());

        model.addAttribute("list", list);
        return "main/faqdetaile";
    }

    @RequestMapping("/main/faqsave")                                            //게시물 추가(관리자)
    public String save(FaqDTO faqDTO, HttpServletRequest request){
        log.info("사용자아이디:{}", faqDTO.getUserUserId());
        //로그인할때 해당 유저아이디 반드시 여기로끌고 와야 한다. 안끌고 오면 게시물이 등록이 안된다.!!
  //      faqDTO.setUserUserId("mong@gmail.com");
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("userId");
        faqDTO.setUserUserId(id);
        return faqService.viewsave(faqDTO) ? "redirect:/main/faq" : "main/faqwriter";
    }

    @RequestMapping("/main/faqmodify")                                              //게시물수정(관리자)
    public String modify(FaqDTO faqDTO, HttpServletRequest request){
        session = request.getSession();
        String id = (String)session.getAttribute("userId");
        log.info("수정 컨트롤러에서 받은아이디:{}", id);
        log.info("새로운제목:{}", faqDTO.getFaqTitle());
        faqDTO.setUserUserId(id);
        log.info("수정 컨트롤러에서 받은 두번째 아이디 :{}", faqDTO.getUserUserId());
        if (faqService.viewmodify(faqDTO)){
            System.out.println("성공!");
            return "redirect:/main/faq";
        }else {
            System.out.println("실패!");
            return "redirect:/main/faqdetaile";
        }
    }

    @RequestMapping(value = "/main/faqdelete", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String delete(FaqDTO faqDTO, HttpServletRequest request, Model model){          //게시물삭제 (관리자) 수정
        log.info("전달받은값확인 번호:{}, 사용자아이디:{}", faqDTO.getFaqNo(), faqDTO.getUserUserId());
        HttpSession session = request.getSession();
        session.setAttribute("userId", faqDTO.getUserUserId());
        boolean oks = faqService.viewdelete(faqDTO.getFaqNo());
        model.addAttribute("okdata", oks);
        return "main/detaile";
    }

   @RequestMapping("/faq/Precautions")              //주의 사항 팝업창 띄우기
    public String Precautionspath() {
        return "main/faqPrecautions";
   }

   @RequestMapping(value="/main/path", method = {RequestMethod.POST, RequestMethod.GET})
   public ModelAndView fowpath(){
        log.info("이동확인");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/faqpath");
        return mv;
   }

   @RequestMapping("/main/fows")
   public ModelAndView fows(){
       log.info("이동두번확인");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/faqfows");
        return mv;
   }
   @RequestMapping("/main/faqup")
   public ModelAndView faqup(){
        log.info("처음이동!");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/faqpows");
        return mv;
   }

}
