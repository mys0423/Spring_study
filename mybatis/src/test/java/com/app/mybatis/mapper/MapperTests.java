package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import com.app.mybatis.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void MapperTests(){
        log.info(timeMapper.getTime());
    }

    @Test
    public void MapperTests2() {
        log.info(timeMapper.getTime2());
    }

    @Test
    public void MapperTests3() {
        log.info("{}", memberMapper.selectAll());
    }

    @Test
    public void MapperTests4() {
        memberMapper.select(1L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void insertTest() {
        MemberVO memberVO = new MemberVO();
//        memberVO.setMemberEmail("test789@gmail.com");
//        memberVO.setMemberPassword("test123!@#");
//        memberVO.setMemberName("장보고");

        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("이순신");

        memberMapper.insert(memberVO);
        log.info("{}", memberMapper.selectAll());
    }

    @Test
    public void updateTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(41L);
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("장길동");
        memberMapper.select(41L).map(MemberVO::toString).ifPresent(log::info);
        memberMapper.update(memberVO);
        memberMapper.select(41L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void deleteTest() {
        memberMapper.delete(41L);
    }
}
