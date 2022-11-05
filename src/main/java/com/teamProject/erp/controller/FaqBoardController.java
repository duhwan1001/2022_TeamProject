package com.teamProject.erp.controller;

import com.teamProject.erp.dto.FaqDTO;
import com.teamProject.erp.service.FaqService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Controller
@Log4j2
@RequiredArgsConstructor
public class FaqBoardController {

    private final FaqService faqService;

    @RequestMapping("/main/writer")             //글쓰기 화면 이동
    public String writer(@RequestParam String getuserFlag, FaqDTO faqDTO, Model model){
        model.addAttribute("user", getuserFlag);
        model.addAttribute("userid", faqDTO.getUserUserId());
        return "main/faqwriter";
    }

    @RequestMapping("/main/faqdetaile")
    public String detaile(@RequestParam String getuserFlag, Model model, FaqDTO faqDTO){             //특정게시물조회(모두가능
        FaqDTO list = faqService.viewdetaile(faqDTO.getFaqNo());
// 로그인시 사용자 userID 가져와야함
 //       String getuser = faqService.getuserflag(list.getUserUserId());

        model.addAttribute("user", getuserFlag);
        model.addAttribute("list", list);
        return "main/faqdetaile";
    }

    @RequestMapping("/main/faqsave")                                            //게시물 추가(관리자)
    public String save(FaqDTO faqDTO){
        //로그인할때 해당 유저아이디 반드시 여기로끌고 와야 한다. 안끌고 오면 게시물이 등록이 안된다.!!
  //      faqDTO.setUserUserId("mong@gmail.com");
        return faqService.viewsave(faqDTO) ? "redirect:/main/faq" : "main/faqwriter";
    }

    @RequestMapping("/main/faqmodify")                                              //게시물수정(관리자)
    public String modify(FaqDTO faqDTO){
        return faqService.viewmodify(faqDTO) ? "redirect:/main/faq" : "main/faqdetaile";
    }

    @RequestMapping("main/faqdelete")
    public String delete(@RequestParam Integer faqno){          //게시물삭제 (관리자) 수정
        boolean oks = faqService.viewdelete(faqno);
        return oks? "redirect:/main/faq" : "main/detaile";
    }

   @RequestMapping("/faq/Precautions")              //주의 사항 팝업창 띄우기
    public String Precautionspath() {
        return "main/faqPrecautions";
   }

}
