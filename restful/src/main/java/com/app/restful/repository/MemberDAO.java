package com.app.restful.repository;

import com.app.restful.domain.vo.MemberVO;
import com.app.restful.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    public List<MemberVO> findAll() {
        return memberMapper.selectAll();
    }

    public MemberVO findById(Long id) {
        return memberMapper.selectById(id);
    }

    public MemberVO findByEmailAndPassword(MemberVO memberVO) {
        return memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
    }

    public void update(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }

    public void delete(Long id) {
        memberMapper.delete(id);
    }
}
