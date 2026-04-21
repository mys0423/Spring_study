package com.app.restfulprac.service;

import com.app.restfulprac.domain.dto.MemberJoinRequestDTO;
import com.app.restfulprac.domain.dto.MemberResponseDTO;
import com.app.restfulprac.domain.dto.MemberUpdateRequestDTO;
import com.app.restfulprac.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void createMemberTest() {
        MemberJoinRequestDTO memberJoinRequestDTO = new MemberJoinRequestDTO();
        memberJoinRequestDTO.setMemberEmail("test147@gmail.com");
        memberJoinRequestDTO.setMemberPassword("1234");
        memberJoinRequestDTO.setMemberName("홍길동");

        memberService.join(memberJoinRequestDTO);
    }

    @Test
    public void getMembersTest() {
        log.info("memberService : {}", memberService.getMembers());
    }

    @Test
    public void getMemberByIdTest() {
        log.info("memberService : {}", memberService.getMemberInfo(1L));
    }

    @Test
    public void memberLoginTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test147@gmail.com");
        memberVO.setMemberPassword("장길동");

        MemberResponseDTO result = memberService.login(memberVO);
        log.info("memberService : {}", result);
    }

    @Test
    public void memberUpdateTest(){
        MemberUpdateRequestDTO memberUpdateRequestDTO = new MemberUpdateRequestDTO();
        memberUpdateRequestDTO.setMemberPassword("123456789");
        memberUpdateRequestDTO.setMemberName("홍길동3");
        memberUpdateRequestDTO.setId(1L);
        memberService.updateMember(memberUpdateRequestDTO);
    }

    @Test
    public void memberDeleteTest(){
        memberService.withdrawMember(65L);
    }
}
