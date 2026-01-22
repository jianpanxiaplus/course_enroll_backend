package com.example.courseenroll.service;

import com.example.courseenroll.entity.Course;
import com.example.courseenroll.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> getAllCourses() {
        return courseMapper.findAll();
    }

    public Course getCourseById(Long id) {
        return courseMapper.findById(id);
    }

    public List<Course> getEnrolledCoursesByStudent(Long studentId) {
        return courseMapper.findEnrolledByStudentId(studentId);
    }

    public Course getById(Long id) {
        return courseMapper.findById(id);
    }

    public void create(Course course) {
        courseMapper.insert(course);
    }

    public void update(Course course) {
        courseMapper.update(course);
    }

    public void delete(Long id) {
        courseMapper.deleteById(id);
    }
}