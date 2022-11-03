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
    //    log.info("이동확인이요!");
        return "main/faqwriter";
    }

    @RequestMapping("/main/faqdetaile")
    public String detaile(@RequestParam Integer faqno, Model model, FaqDTO faqDTO){
    //    log.info("detaile faqno:{}", faqno);
        FaqDTO list = faqService.viewdetaile(faqno);
   //     log.info("사용자 이름:{}", list.getUserUserId());
        model.addAttribute("list", list);
        return "main/faqdetaile";
    }

    @RequestMapping("/main/faqsave")
    public String save(FaqDTO faqDTO){
    //    log.info("컨트롤러 전달받은 값확인 title={}, content={}", faqDTO.getFaqTitle(), faqDTO.getFaqContent());
        faqDTO.setUserUserId("moiu@gmail.com");
        return faqService.viewsave(faqDTO) ? "redirect:/main/faq" : "main/faqwriter";
    }

    @RequestMapping("/main/faqmodify")
    public String modify(FaqDTO faqDTO){
  //      log.info("수정 컨트롤러 동작 값확인 title={}, content={}", faqDTO.getFaqTitle(), faqDTO.getFaqTitle());
        return faqService.viewmodify(faqDTO) ? "redirect:/main/faq" : "main/faqdetaile";
    }

    @RequestMapping("main/delete")
    public String delete(@RequestParam Integer faqno){
        log.info("컨트롤러 수행");
        return faqService.viewdelete(faqno) ? "redirect:/main/faq" : "/main/faqdetaile";
    }

}
