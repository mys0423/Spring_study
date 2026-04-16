package com.app.restful.service;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {

    @Autowired
    private PostService postService;

    @Test
    public void getPostListTest(){
        log.info("postService : {}", postService.getPostList("oldest"));
    }

    @Test
    public void getPostDetailTest(){
        log.info("postService : {}", postService.getPostDetail(1L));
    }

    @Test
    public void createPostTest(){
        PostCreateRequestDTO postCreateRequestDTO = new PostCreateRequestDTO();
        postCreateRequestDTO.setPostTitle("New Post");
        postCreateRequestDTO.setPostContent("New Post Content");
        postService.createPost(postCreateRequestDTO, 1L);
        log.info("postService : {}", postService.getPostList("desc"));
    }

    @Test
    public void modifyPostTest(){
        PostUpdateRequestDTO postUpdateRequestDTO = new PostUpdateRequestDTO();
        postUpdateRequestDTO.setPostTitle("새로운 수정1");
        postUpdateRequestDTO.setPostContent("새 수정 내용1");
        postService.modifyPost(postUpdateRequestDTO, 81L);
        log.info("postService : {}", postService.getPostList("desc"));
    }
}
