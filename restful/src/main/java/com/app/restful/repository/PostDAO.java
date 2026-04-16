package com.app.restful.repository;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public void save(PostVO postVO) { postMapper.insert(postVO); }
    public List<PostDTO> getPosts(Map<String, String> orders) {
        return postMapper.selectAll(orders);
    }
    public Optional<PostDTO> getPost(Long id) {
        return Optional.ofNullable(postMapper.select(id));
    }
    public void update(PostVO postVO) { postMapper.update(postVO); }
    public void delete(Long id) { postMapper.delete(id); }
    public void deleteByMemberId(Long memberId) { postMapper.deleteByMemberId(memberId); }
}