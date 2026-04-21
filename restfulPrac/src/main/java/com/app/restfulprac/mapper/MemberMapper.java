package com.app.restfulprac.mapper;

import com.app.restfulprac.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public void insert(MemberVO memberVO);

    public int existMemberEmail(String memberEmail);

    public List<MemberVO> selectAll();

    public MemberVO selectById(Long Id);

    public MemberVO selectByMemberEmailAndMemberPassword(MemberVO memberVO);

    public void update(MemberVO memberVO);

    public void delete(Long Id);
}
