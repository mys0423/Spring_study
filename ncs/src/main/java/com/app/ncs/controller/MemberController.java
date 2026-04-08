package com.app.ncs.controller;

import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberMapper memberMapper;
    private final HttpSession session;

    @GetMapping("join")
    public void goToJoin(MemberVO memberVO){;}

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        memberMapper.insert(memberVO);
        return new RedirectView("/members/login");
    }

    @GetMapping("login")
    public void goToLogin(MemberVO memberVO){;}

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO){
        Optional<MemberVO> optionalMemberVO = memberMapper.select(memberVO);
        if(optionalMemberVO.isPresent()){
            session.setAttribute("member", optionalMemberVO.get());
            return new RedirectView("/members/my-page");
        }
        return new RedirectView("/members/login");
    }

    @GetMapping("my-page")
    public void goToMyPage(){;}

    @GetMapping("update")
    public void goToUpdate(Model model){
        model.addAttribute("member", session.getAttribute("member"));
    }

    @PostMapping("update")
    public RedirectView update(MemberVO memberVO){
        memberMapper.update(memberVO);
        Optional<MemberVO> optionalMemberVO = memberMapper.select(memberVO);
        if(optionalMemberVO.isPresent()) {
            session.setAttribute("member", optionalMemberVO.get());
        }
        return new RedirectView("/members/my-page");
    }

    public RedirectView logout(){
        session.removeAttribute("member");
        return new RedirectView("/members/login");
    }

    @DeleteMapping("withdraw")
    public RedirectView withdraw(){
        MemberVO memberVO = (MemberVO) session.getAttribute("member");
        memberMapper.delete(memberVO.getId());
        return new RedirectView("/members/join");
    }
}
