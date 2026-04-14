package com.app.restful.repository;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Optional 처리 공식
@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    // 이메일 유무 검사
    public int existMemberEmail(String email) {
        return memberMapper.existMemberEmail(email);
    }

    public List<MemberVO> findAll() {
        return memberMapper.selectAll();
    }

    public Optional<MemberVO> findById(Long id) {
        return Optional.ofNullable(memberMapper.selectById(id));
    }

    public Optional<MemberVO> findByMemberEmailAndMemberPassword(MemberVO memberVO) {
        return Optional.ofNullable(memberMapper.selectByMemberEmailAndMemberPassword(memberVO));
    }

    public void update(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }

    public void delete(Long id) {
        memberMapper.delete(id);
    }
}
