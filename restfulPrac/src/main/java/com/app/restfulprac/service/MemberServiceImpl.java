package com.app.restfulprac.service;

import com.app.restfulprac.domain.dto.MemberResponseDTO;
import com.app.restfulprac.domain.dto.MemberUpdateRequestDTO;
import com.app.restfulprac.exception.MemberException;
import com.app.restfulprac.repository.MemberDAO;
import com.app.restfulprac.domain.dto.MemberJoinRequestDTO;
import com.app.restfulprac.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final MemberResponseDTO memberResponseDTO;

    @Override
    public void join(MemberJoinRequestDTO memberJoinRequestDTO) {
        memberDAO.save(MemberVO.from(memberJoinRequestDTO));
    }

    @Override
    public void checkMemberEmailDuplicate(String memberEmail) {
        if(memberDAO.existMemberEmail(memberEmail) > 0){
            throw new MemberException("이메일이 존재합니다.", HttpStatus.CONFLICT);
        }
    }

    @Override
    public List<MemberResponseDTO> getMembers() {
        return memberDAO.findAll().stream()
                .map(MemberResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    public MemberResponseDTO getMemberInfo(Long id) {
        return memberDAO
                .findById(id)
                .map(MemberResponseDTO::from)
                .orElseThrow(() -> {throw new MemberException("회원이 존재하지 않습니다.", HttpStatus.BAD_REQUEST);});
    }

    @Override
    public MemberResponseDTO login(MemberVO memberVO) {
        return memberDAO
                .findByMemberEmailAndMemberPassword(memberVO)
                .map(MemberResponseDTO::from)
                .orElseThrow(() -> {throw new MemberException("아이디 또는 비번을 확인하세요.", HttpStatus.UNAUTHORIZED);});
    }

    @Override
    public void updateMember(MemberUpdateRequestDTO memberUpdateRequestDTO) {
        memberDAO.update(MemberVO.from(memberUpdateRequestDTO));
    }

    @Override
    public void withdrawMember(Long id) {
        memberDAO.delete(id);
    }
}
