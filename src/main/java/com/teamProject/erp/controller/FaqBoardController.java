package com.teamProject.erp.controller;

import com.teamProject.erp.dto.FaqDTO;
import com.teamProject.erp.service.FaqService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Log4j2
@RequiredArgsConstructor
public class FaqBoardController {

    private final FaqService faqService;

    @RequestMapping("/main/writer")             //글쓰기 화면 이동
    public String writer(){
        return "main/faqwriter";
    }

    @RequestMapping("/main/faqdetaile")
    public String detaile(@RequestParam Integer faqno, Model model, FaqDTO faqDTO){             //특정게시물조회(모두가능)

        FaqDTO list = faqService.viewdetaile(faqno);
// 로그인시 사용자 userID 가져와야함
        String getuser = faqService.getuserflag(list.getUserUserId());


        model.addAttribute("user", getuser);
        model.addAttribute("list", list);
        return "main/faqdetaile";
    }

    @RequestMapping("/main/faqsave")                                            //게시물 추가(관리자)
    public String save(FaqDTO faqDTO){
        faqDTO.setUserUserId("mong@gmail.com");
        return faqService.viewsave(faqDTO) ? "redirect:/main/faq" : "main/faqwriter";
    }

    @RequestMapping("/main/faqmodify")                                              //게시물수정(관리자)
    public String modify(FaqDTO faqDTO){
        return faqService.viewmodify(faqDTO) ? "redirect:/main/faq" : "main/faqdetaile";
    }

    @RequestMapping("main/faqdelete")
    public String delete(@RequestParam Integer faqno){          //게시물삭제 (관리자)
        boolean oks = faqService.viewdelete(faqno);
        return oks? "redirect:/main/faq" : "main/detaile";
    }

   @RequestMapping("/faq/Precautions")              //주의 사항 팝업창 띄우기
    public String Precautionspath(){
        return "main/faqPrecautions";
   }

}
