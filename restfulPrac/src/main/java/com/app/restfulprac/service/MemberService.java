package com.app.restfulprac.service;

import com.app.restfulprac.domain.dto.MemberJoinRequestDTO;
import com.app.restfulprac.domain.dto.MemberResponseDTO;
import com.app.restfulprac.domain.dto.MemberUpdateRequestDTO;
import com.app.restfulprac.domain.vo.MemberVO;

import java.util.List;

public interface MemberService {
    public void join(MemberJoinRequestDTO memberJoinRequestDTO);

    public List<MemberResponseDTO> getMembers();

    public MemberResponseDTO getMemberInfo(Long id);

    public void checkMemberEmailDuplicate(String memberEmail);

    public MemberResponseDTO login(MemberVO memberVO);

    public void updateMember(MemberUpdateRequestDTO memberUpdateRequestDTO);

    public void withdrawMember(Long id);
}
