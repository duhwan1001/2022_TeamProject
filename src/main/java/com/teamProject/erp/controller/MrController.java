package com.teamProject.erp.controller;

import com.teamProject.erp.common.search.Search;
import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.common.paging.PageMaker;
import com.teamProject.erp.dto.MrDTO;
import com.teamProject.erp.service.MrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//@RequestMapping("/mrmain")
public class MrController {

    private final MrService mrService;

    // 게시물 목록
    @RequestMapping(value = "/main/mrmain", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mrmain(@ModelAttribute("s") Search search, ModelAndView mav) {
        log.info("/main/mrmain 호출 됨");
        Map<String, Object> mrMap = mrService.mrFindAllService(search);

        // 페이지 정보 생성
        PageMaker pm = new PageMaker(
                new Page(search.getPageNum(), search.getAmount())
                , (Integer) mrMap.get("tc"));

        mav.addObject("mList", mrMap.get("mList"));
        mav.addObject("pm",pm);

        mav.setViewName("main/mrmain");
        return mav;
    }

    // 게시물 상세 조회 요청
    @RequestMapping(value = "/mrmain/mrdetail", method = {RequestMethod.GET, RequestMethod.POST})
    public String content(@RequestParam Integer mrNo, Model model, HttpServletResponse response, HttpServletRequest request, @ModelAttribute("p") Page page) {
        log.info("/main/mrmain/{} 호출 됨", mrNo);
        MrDTO mrDTO = mrService.mrFindOneService(mrNo, response, request);
        model.addAttribute("m", mrDTO);
        return "mroom/mrdetail";
    }

    // 게시물 쓰기 화면 요청
    @GetMapping("/mrmain/mrwrite")
    public ModelAndView write(HttpSession session, RedirectAttributes ra) {
        log.info("controller request /mrmain/mrwrite GET!");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mroom/mrwrite");
        return mav;
    }

    // 게시물 등록 요청
    @PostMapping("/mrmain/mrwrite")
//    public String write(MrDTO mrDTO, @RequestParam("files")List<MultipartFile> fileList, RedirectAttributes ra, HttpSession session
    public String write(MrDTO mrDTO, RedirectAttributes ra, HttpSession session) {
        log.info("controller request /mrmain/mrwrite POST! - {}", mrDTO);

        //현재 로그인 사용자 계정명 추가
//        mrDTO.setAccount(LoginUtils.getCurrentMemberUserId(session));

        boolean flag = mrService.mrInsertService(mrDTO);
        // 게시물 등록에 성공하면 클라이언트에 성공 메시지 전송
        if (flag) ra.addFlashAttribute("msg", "reg-success");

        return flag ? "redirect:/main" : "redirect:/";
    }

    // 게시물 내용 삭제 확인 요청
    @GetMapping("/mrmain/delete")
    public String delete(@ModelAttribute("mrNo") Integer mrNo, Model model) {
        log.info("controller request /mrmain/delete GET! - {}", mrNo);
//        model.addAttribute("validate", mrService.getMember(mrNo));
        return "mroom/mrdelete";
    }
//    // 게시물 내용 삭제 확정 요청
    @RequestMapping(value = "/mrmain/delete", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView delete(Integer mrNo){
        log.info("controller request /mrmain/delete POST! - {}", mrNo);
        mrService.mrDeleteService(mrNo);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main/mrmain");
        return mav;
    }
    // 수정 화면 요청
    @GetMapping("/mrmain/modify")
    public String modify(Integer mrNo, Model model, HttpServletRequest request, HttpServletResponse response) {
        log.info("controller request /mrmain/modify GET! - mno: {}", mrNo);
        MrDTO mrDTO = mrService.mrFindOneService(mrNo, response, request);
        log.info("find article: {}", mrDTO);

        model.addAttribute("mrDTO", mrDTO);
//        model.addAttribute("validate", mrService.getMember(mrNo));
        return  "mroom/mrmodify";
    }

    // 게시물 수정 처리 요청
    @RequestMapping(value = "/mrmain/modify", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> modify(MrDTO mrDTO){
        log.info("controller request /mrmain/modify POST! - {}", mrDTO);
        boolean flag = mrService.mrModifyService(mrDTO);
        log.info(flag);
        if (flag) {
            return new ResponseEntity<>("성공", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("데이터가 없습니다.", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    //특정 게시물에 붙은 첨부파일경로 리스트를 클라이언트에게 비동기 전송
//    @GetMapping("/file/{mno}")
//    @ResponseBody
//    public ResponseEntity<List<String>> getFiles(@PathVariable Long mno) {
//        List<String> files = mrService.getFiles(mno);
//        log.info("/mrmain/file/{} GET! ASYNC - {}", mno, files);
//
//        return new ResponseEntity<>(files, HttpStatus.OK);
//    }
}
