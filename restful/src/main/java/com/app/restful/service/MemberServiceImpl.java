package com.app.restful.service;

import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    public void join(MemberVO memberVO) {

    }

    public List<MemberVO> getMembers() {
        return memberDAO.findAll();
    }

    @Override
    public Optional<MemberVO> login(MemberVO memberVO) {
        return Optional.empty();
    }

//    회원 정보 조회
    @Override
    public Optional<MemberResponseDTO> getMemberInfo(Long id) {
        // 비밀번호 제거 후 화면에 출력
        return Optional.ofNullable(MemberResponseDTO.from(memberDAO.findById(id)));
    }
}
