package com.teamProject.erp.controller;

import com.teamProject.erp.dto.Member;
import com.teamProject.erp.dto.MemberDTO;
import com.teamProject.erp.service.EditInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequiredArgsConstructor
public class EditInfoController {

    private final EditInfoService editInfoService;

    @RequestMapping(value="/editinfo/edit_request", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editInfo(Member member, HttpServletRequest request) {
        log.info("/editinfo/edit_request 호출 됨");
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        member.setUserId(userId);
        boolean check = editInfoService.editUserInfo(member);

        log.info(member);
        mv.setViewName("editinfo/edit_request");
        return mv;
    }


}
