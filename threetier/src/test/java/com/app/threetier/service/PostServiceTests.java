package com.app.threetier.service;

import com.app.threetier.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PostServiceTests {

    @Autowired
    private PostService postService; // 업캐스팅

    @Test
    void getPostTest(){
        log.info("post: {}", postService.getPost(1L));
    }

    @Test
    public void increaseReadCountTest(){
        postService.increaseReadCount(1L);
    }

    @Test
    public void updatePostTest(){
        PostVO postVO = new PostVO();
        postVO.setId(1L);
        postVO.setPostTitle("수정된 게시글1");
        postVO.setPostContent("수정된 내용1");
        postService.updatePost(postVO);

        log.info("post: {}", postService.getPost(1L));
    }

    @Test
    public void deletePostTest(){
        postService.deletePost(2L);
    }

}
