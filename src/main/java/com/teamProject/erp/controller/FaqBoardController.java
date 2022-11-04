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
    public String detaile(@RequestParam Integer faqno, Model model, FaqDTO faqDTO){

        FaqDTO list = faqService.viewdetaile(faqno);
        log.info("모든값확인 번호:{}, 제목:{}, 내용:{} 아이디:{}", list.getFaqNo(), list.getFaqTitle(), list.getFaqContent(), list.getUserUserId());
// 로그인시 사용자 userID 가져와야함
        String getuser = faqService.getuserflag(list.getUserUserId());
        log.info("아이디플래그 구분:{}", getuser);

        model.addAttribute("user", getuser);
        model.addAttribute("list", list);
        return "main/faqdetaile";
    }

    @RequestMapping("/main/faqsave")
    public String save(FaqDTO faqDTO){
        faqDTO.setUserUserId("mong@gmail.com");
        log.info("title값:{}", faqDTO.getFaqTitle(), faqDTO.getFaqTitle());
        return faqService.viewsave(faqDTO) ? "redirect:/main/faq" : "main/faqwriter";
    }

    @RequestMapping("/main/faqmodify")
    public String modify(FaqDTO faqDTO){
        return faqService.viewmodify(faqDTO) ? "redirect:/main/faq" : "main/faqdetaile";
    }

    @RequestMapping("main/faqdelete")
    public String delete(@RequestParam Integer faqno){
        log.info("faqno값확인:{}", faqno);
        boolean oks = faqService.viewdelete(faqno);
        log.info("삭제 리턴값:{}", oks);
        return oks? "redirect:/main/faq" : "main/detaile";
    }

}
