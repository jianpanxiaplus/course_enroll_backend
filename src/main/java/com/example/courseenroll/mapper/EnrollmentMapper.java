package com.example.courseenroll.mapper;

import com.example.courseenroll.entity.Enrollment;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EnrollmentMapper {
    void insert(Enrollment enrollment);
    void deleteByStudentAndCourse(Long studentId, Long courseId);
    List<Enrollment> findByStudentId(Long studentId);
    boolean exists(Long studentId, Long courseId);
}