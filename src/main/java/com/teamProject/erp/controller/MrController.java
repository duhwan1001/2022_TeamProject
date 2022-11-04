package com.teamProject.erp.controller;

import com.teamProject.erp.common.Search.Search;
import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.common.paging.PageMaker;
import com.teamProject.erp.dto.MrDTO;
import com.teamProject.erp.service.MrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
public class MrController {

    private final MrService mrService;

    // 회의실 목록
    @GetMapping("/list")
    public String list(@ModelAttribute("s") Search search, Model model) {
        log.info("controller request /main/list GET! - search : {}", search);

        Map<String, Object> mrMap = mrService.mrFindAllService(search);
        log.debug("return data - {}", mrMap);

        //페이지 정보 생성
        PageMaker pm = new PageMaker( new Page(search.getPageNum(), search.getAmount()), (Integer) mrMap.get("tc"));

        model.addAttribute("mList", mrMap.get("mList"));
        model.addAttribute("pm", pm);

        return "main/mrmain";
    }
//    @RequestMapping(value = "/main/mrmain", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mrList() {
//        log.info("/main/mrmain 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("main/mrmain");
//        return mv;
//    }

    // 회의실 상세
    @GetMapping("/content/{mrNo}")
    public String content(@PathVariable Long mrNo, Model model, @ModelAttribute("p") Page page) {
        log.info("controller request /mrmain/content GET! - {}", mrNo);
        MrDTO mrDTO = mrService.mrFindOneService(mrNo);
        model.addAttribute("b", mrDTO);
        return "mrmain/mrdetail";
    }
//    @RequestMapping(value = "/mrmain/mrdetail", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mrDetail() {
//        log.info("/mrmain/mrdetail 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("mroom/mrdetail");
//        return mv;
//    }

    // 회의실 쓰기 화면 요청
    @GetMapping("/write")
    public String write(HttpSession session, RedirectAttributes ra) {
        log.info("controller request /mrmain/write GET!");
        return "main/mrwrite";
    }

    // 회의실 예약 등록 요청
    @PostMapping("/write")
    public String write(MrDTO mrDTO,
                        @RequestParam("files")List<MultipartFile> fileList,
                        RedirectAttributes ra
//                        ,HttpSession session
    ) {
        log.info("controller request /main/write POST! - {}", mrDTO);

        //현재 로그인 사용자 계정명 추가
//        mrDTO.setUserId(LoginUtils.getCurrentMemberUserId(session));

        boolean flag = mrService.mrInsertService(mrDTO);
        // 게시물 등록에 성공하면 클라이언트에 성공 메시지 전송
        if (flag) ra.addFlashAttribute("msg", "reg-success");

        return flag ? "redirect:/mrmain/mrwrite" : "redirect:/";
    }
//    @RequestMapping(value = "/mrmain/mrwrite", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mrWrite() {
//        log.info("/mrmain/mrwrite 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("mroom/mrwrite");
//        return mv;
//    }

    // 회의실 내용 삭제 확인 요청
    @GetMapping("/delete")
    public String delete(@ModelAttribute("mrNo") Long mrNo, Model model) {
        log.info("controller request /mrdetail/delete GET! - mno: {}", mrNo);

        model.addAttribute("validate", mrService.getMember(mrNo));

        return "mrdetail/mrdelete";
    }

    // 회의실 내용 삭제 확정 요청
    @PostMapping("/delete")
    public String delete(Long mrNo) {
        log.info("controller request /mrdetail/delete POST! - mno: {}", mrNo);

        return mrService.mrDeleteService(mrNo) ? "redirect:/mrmain/list" : "redirect:/";
    }

    // 회의실 수정 화면 요청
    @GetMapping("/modify")
    public String modify(Long mrNo, Model model) {
        log.info("controller request /detail/modify GET! - {}", mrNo);
        MrDTO mrDTO = mrService.mrFindOneService(mrNo);
        log.info("find article: {}", mrDTO);
        model.addAttribute("mrDTO", mrDTO);
        model.addAttribute("validate", mrService.getMember(mrNo));
        return "mrdetail/mrmodify";
    }

    // 회의실 수정 처리 요청
    @PostMapping("/modify")
    public String modify(MrDTO mrDTO) {
        log.info("controller request /detail/modify POST! - {}", mrDTO);
        boolean flag = mrService.mrModifyService(mrDTO);
        return flag ? "redirect:/mrdetail/content/" + mrDTO.getMrNo() : "redirect:/";
    }
//    @RequestMapping(value = "/mrdetail/mrmodify", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView mrModify() {
//        log.info("/mrdetail/mrmodify 호출 됨");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("mroom/mrmodify");
//        return mv;
//    }
}
