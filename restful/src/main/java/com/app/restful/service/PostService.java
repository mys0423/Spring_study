package com.app.restful.service;

import com.app.restful.domain.vo.PostVO;
import java.util.List;

public interface PostService {
    public void write(PostVO postVO);
    public List<PostVO> getPosts();
    public PostVO getPostInfo(Long id);
    public void updatePost(PostVO postVO);
    public void removePost(Long id);
}