package com.app.restfulprac.repository;

import com.app.restfulprac.domain.vo.MemberVO;
import com.app.restfulprac.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

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
