package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberUpdateRequestDTO memberUpdateRequestDTO;

    @Test
    public void getMember(){
        log.info("memberService : {}", memberService.getMemberInfo(1L));
    }

    @Test
    public void insertMemberTest(){
        MemberJoinRequestDTO memberJoinRequestDTO = new MemberJoinRequestDTO();
        memberJoinRequestDTO.setMemberEmail("test147@gmail.com");
        memberJoinRequestDTO.setMemberName("1234");
        memberJoinRequestDTO.setMemberName("장길동");

        memberService.join(memberJoinRequestDTO);
    }

    @Test
    public void memberUpdateTest(){
        MemberUpdateRequestDTO memberUpdateRequestDTO = new MemberUpdateRequestDTO();
        memberUpdateRequestDTO.setMemberPassword("123456789");
        memberUpdateRequestDTO.setMemberName("홍길동3");
        memberUpdateRequestDTO.setId(1L);
        memberService.updateMember(memberUpdateRequestDTO);
    }
}
