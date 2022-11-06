package com.teamProject.erp.controller;

import com.teamProject.erp.common.search.Search;
import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.common.paging.PageMaker;
import com.teamProject.erp.dto.NoticeDTO;
import com.teamProject.erp.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

//    @RequestMapping(value="/notice", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView notice() {
//        log.info("/main/notice 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("main/notice");
//        return mv;
//    }

    // 게시물 목록 요청
    @RequestMapping(value = "/main/notice", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView notice(@ModelAttribute("s") Search search, ModelAndView mav) {
        log.info("/main/notice 호출 됨");
        Map<String, Object> noticeMap = noticeService.noticeFindAllService(search);

        PageMaker pm = new PageMaker(
                new Page(search.getPageNum(), search.getAmount())
                , (Integer) noticeMap.get("tc"));

        mav.addObject("nList", noticeMap.get("nList"));
        mav.addObject("pm", pm);

        mav.setViewName("main/notice");
        return mav;
    }

    @RequestMapping(value = "/notice/noticeview", method = {RequestMethod.GET, RequestMethod.POST})
    public String view(@RequestParam Integer noticeNo, Model model, HttpServletResponse response, HttpServletRequest request, @ModelAttribute("p") Page page) {
        log.info("/notice/noticeview/{} 호출 됨", noticeNo);
        NoticeDTO noticeDTO = noticeService.noticeFindOneService(noticeNo, response, request);
        model.addAttribute("n", noticeDTO);
        return "notice/noticeview";
    }

    @GetMapping(value = "/notice/noticewrite")
    public ModelAndView write(HttpSession session, RedirectAttributes ra) {
        log.info("/notice/noticewrite 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notice/noticewrite");
        return mv;
    }

    @PostMapping(value = "/notice/noticewrite")
    public String write(NoticeDTO noticeDTO, RedirectAttributes ra, HttpSession session) {
        log.info("/notice/noticewrite 호출 됨");
        boolean flag = noticeService.noticeInsertService(noticeDTO);
//        // 게시물 등록에 성공하면 클라이언트에 성공메세지 전송
        if (flag) ra.addFlashAttribute("msg", "reg-success");
        return flag ? "redirect:/main" : "redirect:/";
    }

    // 게시물 삭제 확인 요청
    @GetMapping("/delete")
    public String delete(@ModelAttribute("noticeNo") Long noticeNo, Model model) {
        log.info("controller request /notice/delete GET! - {}", noticeNo);
//        model.addAttribute("validate", noticeService.getMember(noticeNo));
        return "notice/noticedelete";
    }

    // 게시물 삭제 확정 요청
    @PostMapping("/delete")
    public String delete(int noticeNo) {
        log.info("controller request /notice/delete POST! - nno: {}", noticeNo);
        return noticeService.noticeDeleteService(noticeNo) ? "redirect:/notice/list" : "redirect:/";
    }

    // 수정 화면 요청
    @GetMapping("/notice/modify")
    public String modify(int noticeNo, Model model, HttpServletRequest request, HttpServletResponse response) {
        log.info("controller request /notice/modify GET! - nno: {}", noticeNo);
        NoticeDTO noticeDTO = noticeService.noticeFindOneService(noticeNo, response, request);
        log.info("find article: {}", noticeDTO);

        model.addAttribute("noticeDTO", noticeDTO);
//        model.addAttribute("validate", noticeService.getMember(noticeNo));

        return "notice/noticemodify";
    }

    // 수정 처리 요청
    @PostMapping("/notice/modify")
    public String modify(NoticeDTO noticeDTO) {
        log.info("controller request /notice/modify POST! - {}", noticeDTO);
        boolean flag = noticeService.noticeModifyService(noticeDTO);
        return flag ? "redirect:/notice/noticeview?noticeNo=" + noticeDTO.getNoticeNo() : "redirect:/";
    }

    // 특정 게시물에 붙은 첨부파일경로 리스트를 클라이언트에게 비돈기 전송
//    @GetMapping("/file/{nno}")
//    @ResponseBody
//    public ResponseEntity<List<String>> getFiles(@PathVariable Long nno) {
//        List<String> files = noticeService.getFiles(nno);
//        log.info("/notice/file/{} GET! ASYNC - {}", nno, files);
//
//        return new ResponseEntity<>(files, HttpStatus.OK);
//    }
}
