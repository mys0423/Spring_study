package com.app.threetier.repository;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import com.app.threetier.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// FM
// Mapper, DAO는 Optional로 감싸지 않는다.
// 유지보수에서 혼란이 생길 수 있다.
@Repository
@RequiredArgsConstructor
public class StudentDAO {
    private final StudentMapper studentMapper;

    public void save(StudentVO studentVO) {
        studentMapper.insert(studentVO);
    }

    public List<StudentDTO> findAll() {
        return studentMapper.selectAll();
    }

    public StudentDTO findById(Long id) {
        return studentMapper.select(id);
    }

    public void update(StudentVO studentVO) {
        studentMapper.update(studentVO);
    }

    public void delete(Long id) {
        studentMapper.delete(id);
    }
}
