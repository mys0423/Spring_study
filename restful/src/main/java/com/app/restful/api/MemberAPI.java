package com.app.restful.api;

import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// 리턴값을 JSON으로 처리
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

//    회원 목록 조회 서비스
    @GetMapping("")
    public List<MemberResponseDTO> getMemberLists() {
        return memberService.getMembers().stream()
                .map(MemberResponseDTO::from)
                .collect(Collectors.toList());
    }

//    회원 정보 조회 서비스
    @GetMapping("/{id}")
    public MemberResponseDTO getMemberInfo(@PathVariable Long id){
        Optional<MemberResponseDTO> foundMember = memberService.getMemberInfo(id);
        if(foundMember.isPresent()){
            return foundMember.get();
        }
        return new MemberResponseDTO();
    }
}
