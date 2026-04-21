package com.app.restfulprac.domain.vo;

import com.app.restfulprac.domain.dto.MemberJoinRequestDTO;
import com.app.restfulprac.domain.dto.MemberUpdateRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class MemberVO implements Serializable {
    private Long id;
    private String memberEmail;
    private String memberName;
    private String memberPassword;

    public static MemberVO from (MemberJoinRequestDTO memberJoinRequestDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
        memberVO.setMemberName(memberJoinRequestDTO.getMemberName());
        memberVO.setMemberPassword(memberJoinRequestDTO.getMemberPassword());
        return memberVO;
    }

    public static MemberVO from (MemberUpdateRequestDTO memberUpdateRequestDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(memberUpdateRequestDTO.getId());
        memberVO.setMemberName(memberUpdateRequestDTO.getMemberName());
        memberVO.setMemberPassword(memberUpdateRequestDTO.getMemberPassword());
        return memberVO;
    }

}
