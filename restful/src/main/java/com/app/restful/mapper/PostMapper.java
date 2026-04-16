package com.app.restful.mapper;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface PostMapper {
    public List<PostDTO> selectAll(Map<String, String> orders);
    public PostDTO select(Long id);
    public void insert(PostVO postVO);
    public void update(PostVO postVO);
    public void delete(Long id);
    public void deleteByMemberId(Long memberId);
}