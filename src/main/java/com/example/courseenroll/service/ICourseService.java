package com.example.courseenroll.service;

import com.example.courseenroll.entity.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();

    Course getCourseById(Long id) ;

    List<Course> getEnrolledCoursesByStudent(Long studentId);

    Course getById(Long id);

    void create(Course course);

    void update(Course course);

    void delete(Long id);
}
