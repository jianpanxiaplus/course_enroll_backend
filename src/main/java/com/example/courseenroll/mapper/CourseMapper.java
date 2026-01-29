package com.example.courseenroll.mapper;

import com.example.courseenroll.entity.Course;
import com.example.courseenroll.req.CourseReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findAll();
    Course findById(Long id);
    int countEnrollments(Long courseId);
    List<Course> findEnrolledByStudentId(Long studentId);
    void insert(Course course);
    void update(Course course);
    void deleteById(Long id);

    List<Course> findAvailableByFilters(@Param("courseReq") CourseReq courseReq);
}

