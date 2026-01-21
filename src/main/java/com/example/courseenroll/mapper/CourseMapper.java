package com.example.courseenroll.mapper;

import com.example.courseenroll.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findAll();
    Course findById(Long id);
    int countEnrollments(Long courseId);
    List<Course> findEnrolledByStudentId(Long studentId);
}

