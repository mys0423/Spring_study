package com.app.threetier.service;

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
}
