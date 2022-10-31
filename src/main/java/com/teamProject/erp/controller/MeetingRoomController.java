package com.teamProject.erp.controller;

import com.teamProject.erp.common.Search.Search;
import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.common.paging.PageMaker;
import com.teamProject.erp.dto.MeetingDTO;
import com.teamProject.erp.service.MeetingRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
@RequestMapping("/mrmain")
public class MeetingRoomController {

    private final MeetingRoomService meetingRoomService;

    // 게시물 목록 요청
    @GetMapping("/mrList")
    public String mrList(@ModelAttribute("s")Search search, Model model) {
        log.info("controller request /MRoom/mrList GET! - search: {}", search);

        Map<String, Object> mrMap = meetingRoomService.findAllService(search);
        log.debug("return data - {}", mrMap);

        // 페이지 정보 생성
        PageMaker pm = new PageMaker(
                new Page(search.getPageNum(), search.getAmount())
                , (Integer) mrMap.get("tc"));

        model.addAttribute("mList", mrMap.get("mList"));
        model.addAttribute("pm", pm);

        return "mrmain/mrList";
    }

    // 게시물 상세 조회 요청
    @GetMapping("/mrDetail/{mrNo}")
    public String content(@PathVariable Long mrNo
        , Model model, HttpServletResponse response, HttpServletRequest request, @ModelAttribute("p") Page page) {
        log.info("controller request /MRoom/content GET! - {}", mrNo);
        MeetingDTO meetingDTO = meetingRoomService.findOneService(mrNo, response, request);
        log.info("return data - {}", meetingDTO);
        model.addAttribute("m", meetingDTO);
        return "mrList/mrDetail";
    }

    // 게시물 쓰기 화면 요청
    @GetMapping("/mrWrite")
    public String write(HttpSession session, RedirectAttributes ra) {
        log.info("controller request /MRoom/write GET!");
        return "mrList/mrWrite";
    }

    // 게시물 등록 요청
    @PostMapping("/mrWrite")
    public String write(MeetingDTO meetingDTO,
                        @RequestParam("files")List<MultipartFile> fileList,
                        RedirectAttributes ra,
                        HttpSession session
    ) {
        log.info("controller request /MRoom/write POST! - {}", meetingDTO);

        // 현재 로그인 사용자 계정명 추가
//        meetingDTO.setUserId(LoginUtils.getCurrentMemberAccount(session));

        boolean flag = meetingRoomService.saveService(meetingDTO);
        // 게시물 등록에 성공하면 클라이언트에 성공메시지 전송
        if (flag) ra.addFlashAttribute("msg", "reg-success");

        return flag ? "redirect:/mrmain/mrList" : "redirect:/";
    }

    // 게시물 삭제 확인 요청
    @GetMapping("/mrDelete")
    public String delete(@ModelAttribute("mrNo") Long mrNo, Model model) {
        log.info("controller request /MRoom/delete GET! - mno: {}", mrNo);
        model.addAttribute("validate", meetingRoomService.getMember(mrNo));

        return "mrmain/mrDelete";
    }

    // 게시물 삭제 확정 요청
    @PostMapping("/mrDelete")
    public String delete(Long mrNo) {
        log.info("controller request /MRoom/delete POST! - mno: {}", mrNo);

        return meetingRoomService.removeService(mrNo) ? "redirect:/mrmain/mrList" : "redirect:/";
    }

    // 수정 화면 요청
    @GetMapping("/mrModify")
    public String modify(Long mrNo, Model model, HttpServletRequest request, HttpServletResponse response) {
        log.info("controller request /MRoom/mrModify GET! - mno: {}", mrNo);
        MeetingDTO meetingDTO = meetingRoomService.findOneService(mrNo, response, request);
        log.info("find article: {}", meetingDTO);

        model.addAttribute("meetingDTO", meetingDTO);
        model.addAttribute("validate", meetingRoomService.getMember(mrNo));

        return "mrList/mrModify";
    }

    // 수정 처리 요청
    @PostMapping("/mrModify")
    public String modify(MeetingDTO meetingDTO) {
        log.info("controller request /MRoom/modify POST! - {}", meetingDTO);
        boolean flag = meetingRoomService.modifyService(meetingDTO);
        return flag ? "redirect:/mrmain/mrDetail" + meetingDTO.getMrNo() : "redirect:/";
    }

    // 특정 게시물에 붙은 첨부파일결로 리스트를 클라이언트에게 비동기 전송
    @GetMapping("/file/{mno}")
    @ResponseBody
    public ResponseEntity<List<String>> getFiles(@PathVariable Long mno) {

        List<String> files = meetingRoomService.getFiles(mno);
        log.info("/main/file/{} GET! ASYNC - {}", mno, files);

        return new ResponseEntity<>(files, HttpStatus.OK);
    }

//    // 회의실 메인
//    @RequestMapping(value="/main/mrmain", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mrMain() {
//        log.info("/main/mrmain 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("main/mrmain");
//        return mv;
//    }
//
//    @RequestMapping(value="/main/mrdetail", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mrDetail() {
//        log.info("/main/mrdetail 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("MRoom/mrDetail");
//        return mv;
//    }
//    @RequestMapping(value="/main/mrlist", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mrList() {
//        log.info("/main/mrlist 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("MRoom/mrList");
//        return mv;
//    }
//    @RequestMapping(value="/mrlist/mrwrite", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mrWrite() {
//        log.info("/main/mrwrite 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("mrWrite");
//        return mv;
//    }
//    @RequestMapping(value="/mrdetail/mrmodify", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mrModify() {
//        log.info("/main/mrmodify 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("mrModify");
//        return mv;
//    }
}
