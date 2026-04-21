package com.app.restfulprac.domain.dto;

import com.app.restfulprac.domain.vo.MemberVO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberResponseDTO {
    private Long id;
    private String memberEmail;
    private String memberName;

    public static MemberResponseDTO from(MemberVO memberVO) {

        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        memberResponseDTO.setId(memberVO.getId());
        memberResponseDTO.setMemberEmail(memberVO.getMemberEmail());
        memberResponseDTO.setMemberName(memberVO.getMemberName());
        return memberResponseDTO;
    }
}
