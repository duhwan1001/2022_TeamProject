package com.teamProject.erp.controller;

import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.common.paging.PageMaker;
import com.teamProject.erp.common.search.Search;
import com.teamProject.erp.dto.NoticeDTO;
import com.teamProject.erp.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
//@RequestMapping("/notice")
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
    @RequestMapping(value="/main/notice", method = {RequestMethod.GET, RequestMethod.POST})
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

    // 공지사항 목록 요청
//    @GetMapping("/list")
//    public String list(@ModelAttribute("s") Search search, Model model) {
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
//        return "main/notice";
//    }

    // 게시물 상세 조회 요청
    @RequestMapping(value = "/notice/noticeview/", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView content(Integer noticeNo, ModelAndView mav, HttpServletResponse response, HttpServletRequest request, @ModelAttribute("p") Page page) {
        log.info("/main/notice/content/{} 호출 됨", noticeNo);
        NoticeDTO noticeDTO = noticeService.noticeFindOneService(noticeNo, response, request);
        mav.addObject("n", noticeDTO);
        mav.setViewName("notice/noticeview");
        return mav;
    }

    // 게시물 상세 조회 요청
//    @GetMapping("/content/{noticeNo}")
//    public String content(@PathVariable Long noticeNo, Model model, HttpServletResponse response, HttpServletRequest request, @ModelAttribute("p") Page page) {
//        log.info("controller request /notice/content GET! - {}", noticeNo);
//        NoticeDTO noticeDTO = noticeService.noticeFindOneService(noticeNo, response, request);
//        log.info("return data - {}", noticeDTO);
//        model.addAttribute("n", noticeDTO);
//        return "notice/noticeview";
//    }

    // 게시물 쓰기 화면 요청
    @GetMapping("/write")
    public String write(HttpSession session, RedirectAttributes ra) {
        log.info("controller request /notice/write GET!");
        return "notice/noticewrite";
    }

    // 게시물 등록 요청
    @PostMapping("/write")
//    public String write(NoticeDTO noticeDTO, @RequestParam("files") List<MultipartFile> fileList, RedirectAttributes ra, HttpSession session) {
    public String write(NoticeDTO noticeDTO, RedirectAttributes ra, HttpSession session) {
        log.info("controller request /notice/write POST! - {}", noticeDTO);

        // 현재 로그인 사용자 계정명 추가
//        noticeDTO.setAccount(LoginUtils.getCurrentMemberAccount(session));

        boolean flag = noticeService.noticeInsertService(noticeDTO);
        // 게시물 등록에 성공하면 클라이언트에 성공메세지 전송
        if (flag) ra.addFlashAttribute("msg", "reg-success");

        return flag ? "redirect:/notice/list" : "redirect:/";
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
    @GetMapping("/modify")
    public String modify(int noticeNo, Model model, HttpServletRequest request, HttpServletResponse response) {
        log.info("controller request /notice/modify GET! - nno: {}", noticeNo);
        NoticeDTO noticeDTO = noticeService.noticeFindOneService(noticeNo, response, request);
        log.info("find article: {}", noticeDTO);

        model.addAttribute("noticeDTO", noticeDTO);
//        model.addAttribute("validate", noticeService.getMember(noticeNo));

        return "notice/noticemodify";
    }

    // 수정 처리 요청
    @PostMapping("/modify")
    public String modify(NoticeDTO noticeDTO) {
        log.info("controller request /notice/modify POST! - {}", noticeDTO);
        boolean flag = noticeService.noticeModifyService(noticeDTO);
        return flag ? "redirect:/notice/content/" + noticeDTO.getNoticeNo() : "redirect:/";
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
