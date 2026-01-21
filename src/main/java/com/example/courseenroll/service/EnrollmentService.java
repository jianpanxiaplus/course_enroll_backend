package com.example.courseenroll.service;

import com.example.courseenroll.entity.Course;
import com.example.courseenroll.entity.Enrollment;
import com.example.courseenroll.mapper.CourseMapper;
import com.example.courseenroll.mapper.EnrollmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Transactional
    public String enroll(Long studentId, Long courseId) {
        if (enrollmentMapper.exists(studentId, courseId)) {
            return "已报名该课程";
        }

        Course course = courseMapper.findById(courseId);
        int currentCount = courseMapper.countEnrollments(courseId);
        if (currentCount >= course.getMaxCapacity()) {
            return "课程人数已满";
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(studentId);
        enrollment.setCourseId(courseId);
        enrollmentMapper.insert(enrollment);
        return "报名成功";
    }

    @Transactional
    public String cancelEnroll(Long studentId, Long courseId) {
        if (!enrollmentMapper.exists(studentId, courseId)) {
            return "未报名该课程";
        }
        enrollmentMapper.deleteByStudentAndCourse(studentId, courseId);
        return "取消成功";
    }
}