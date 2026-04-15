package com.app.restful.mapper;

import com.app.restful.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PostMapper {
    public void insert(PostVO postVO);
    public List<PostVO> selectAll();
    public PostVO selectById(Long id);
    public void update(PostVO postVO);
    public void updateReadCount(Long id);
    public void delete(Long id);
}