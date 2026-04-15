package com.app.restful.service;

import com.app.restful.domain.vo.PostVO;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO); // 변환할 필요 없이 바로 저장!
    }

    @Override
    public List<PostVO> getPosts() {
        return postDAO.findAll();
    }

    @Override
    public PostVO getPostInfo(Long id) {
        postDAO.updateReadCount(id);
        return postDAO.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
    }

    @Override
    public void updatePost(PostVO postVO) {
        postDAO.update(postVO);
    }

    @Override
    public void removePost(Long id) {
        postDAO.delete(id);
    }
}