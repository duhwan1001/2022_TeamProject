package com.teamProject.erp.controller;

import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.common.paging.PageMaker;
import com.teamProject.erp.common.search.Search;
import com.teamProject.erp.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
//@RequestMapping("/main")
public class NoticeController {

    private final NoticeService noticeService;

    // 공지사항 세부
    @RequestMapping(value="/notice/noticeview", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView noticeView() {
        log.info("/notice/noticeview 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notice/noticeview");
        return mv;
    }

    // 공지사항 등록
    @RequestMapping(value="/main/noticewrite", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView noticeWrite() {
        log.info("/main/noticewrite 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notice/noticewrite");
        return mv;
    }

    // 공지사항 수정
    @RequestMapping(value="/noticeview/noticemodify", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView noticeModify() {
        log.info("/noticeview/noticemodify 호출 됨");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notice/noticemodify");
        return mv;
    }

//    @RequestMapping("/notice")
//    public ModelAndView notice() {
//        log.info("/notice 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("notice");
//        return mv;
//    }

    // 공지사항 목록 요청
//    @GetMapping("/notice")
//    public String list(@ModelAttribute("s")Search search, Model model) {
//        log.info("controller request /notice/list GET!! - search: {}", search);
//
//        Map<String, Object> noticeMap = noticeService.noticeFindAllService(search);
//        log.debug("return data - {}", noticeMap);
//
//        // 페이지 정보 생성
//        PageMaker pm = new PageMaker(
//                new Page(search.getPageNum(), search.getAmount())
//                , (Integer) noticeMap.get("tc"));
//
//        model.addAttribute("nList", noticeMap.get("nList"));
//        model.addAttribute("pm", pm);
//
//        return "notice";
//    }
}
