package com.app.threetier.controller;

import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberMapper memberMapper; // 생성자 주입
    private final HttpSession session;

//    회원 가입
    @GetMapping("join")
    public void goTojoin(MemberVO memberVO){;} // 생략 가능

//    값을 받아서(요청) -> DB에 저장
    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        memberMapper.insert(memberVO);
        return new RedirectView("/members/login");
    }

    @GetMapping("login")
    public void doToLogin(MemberVO memberVO){;}

//    로그인 실습
//    로그인이 완료되면 /members/my-page로 응답
    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes){ // flush 영역 사용
        Optional<MemberVO> foundMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        if(foundMember.isPresent()){
            session.setAttribute("member",foundMember.get());
            return new RedirectView("/members/my-page");
        }

//        리다이렉트와 세션을 통해 화면 상태를 관리하면
//        session 과부화 되므로 session에 flash영역에 주입이 되며 새로운 요청이 들어왔을 때
//        redirectAttributes.addFlashAttribute("key", value): 컨트롤러에서 사용이 가능
//        redirectAttributes.addAttribute("isLogin", true): 컨트롤러에서 사용이 불가능

        redirectAttributes.addFlashAttribute("isLogin", false);
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
        Optional<MemberVO> foundMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        if(foundMember.isPresent()){
            session.setAttribute("member",foundMember.get());
        }
        return new RedirectView("/members/my-page");
    }

//    로그아웃
    public RedirectView logout(){
//        invalidate: 세션 값을 초기화
        session.invalidate();
        session.removeAttribute("member");
        return new RedirectView("/members/login");
    }

//    회원 탈퇴
    @DeleteMapping("withdraw")
    public RedirectView withdraw(){
        MemberVO member = (MemberVO)session.getAttribute("member");
        memberMapper.delete(member.getId());
        return new RedirectView("/members/login");
    }
}
