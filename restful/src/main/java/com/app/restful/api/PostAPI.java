package com.app.restful.api;

import com.app.restful.domain.vo.PostVO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostAPI {

    private final PostService postService;

    @Operation(summary = "게시글 목록 조회")
    @GetMapping("")
    public List<PostVO> getPostLists() {
        return postService.getPosts();
    }

    @Operation(summary = "게시글 단일 조회")
    @GetMapping("/{id}")
    public PostVO getPostInfo(@PathVariable Long id){
        return postService.getPostInfo(id);
    }

    @Operation(summary = "게시글 작성")
    @PostMapping("/write")
    public void writePost(@RequestBody PostVO postVO) {
        postService.write(postVO);
    }

    @Operation(summary = "게시글 수정")
    @PutMapping("/{id}")
    public void updatePost(@RequestBody PostVO postVO, @PathVariable Long id){
        postVO.setId(id); // URL로 넘어온 id를 세팅
        postService.updatePost(postVO);
    }

    @Operation(summary = "게시글 삭제")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.removePost(id);
    }
}