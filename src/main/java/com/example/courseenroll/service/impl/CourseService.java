package com.example.courseenroll.service.impl;

import com.example.courseenroll.entity.Course;
import com.example.courseenroll.mapper.CourseMapper;
import com.example.courseenroll.mapper.EnrollmentMapper;
import com.example.courseenroll.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Override
    public List<Course> getAllCourses() {
        List<Course> courseList = courseMapper.findAll();
        courseList.forEach(course -> {
            Long studentId = 1L;
            boolean exists = enrollmentMapper.exists(studentId, course.getId());
            course.setEnrolled(exists);
        });
        return courseList;
    }

    @Override
    public Course getCourseById(Long id) {
        return courseMapper.findById(id);
    }

    @Override
    public List<Course> getEnrolledCoursesByStudent(Long studentId) {
        return courseMapper.findEnrolledByStudentId(studentId);
    }

    @Override
    public Course getById(Long id) {
        Course course = courseMapper.findById(id);
        Long studentId = 1L;
        boolean exists = enrollmentMapper.exists(studentId, course.getId());
        course.setEnrolled(exists);
        return course;
    }

    @Override
    public void create(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public void update(Course course) {
        courseMapper.update(course);
    }

    @Override
    public void delete(Long id) {
        courseMapper.deleteById(id);
    }
}