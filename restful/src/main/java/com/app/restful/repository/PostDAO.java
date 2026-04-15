package com.app.restful.repository;

import com.app.restful.domain.vo.PostVO;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public void save(PostVO postVO) { postMapper.insert(postVO); }
    public List<PostVO> findAll() { return postMapper.selectAll(); }
    public Optional<PostVO> findById(Long id) { return Optional.ofNullable(postMapper.selectById(id)); }
    public void update(PostVO postVO) { postMapper.update(postVO); }
    public void updateReadCount(Long id) { postMapper.updateReadCount(id); }
    public void delete(Long id) { postMapper.delete(id); }
}