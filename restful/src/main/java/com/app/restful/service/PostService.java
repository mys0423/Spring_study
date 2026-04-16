package com.app.restful.service;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import java.util.List;

public interface PostService {
    public void createPost(PostCreateRequestDTO postCreateRequestDTO, Long memberId);
    public List<PostDTO> getPostList(String order);
    public PostDTO getPostDetail(Long id);
    public void modifyPost(PostUpdateRequestDTO postUpdateRequestDTO, Long id);
    public void remove(Long id);
    public void removeByMemberId(Long memberId);
}