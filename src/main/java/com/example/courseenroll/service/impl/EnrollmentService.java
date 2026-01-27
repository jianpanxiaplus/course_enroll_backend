package com.example.courseenroll.service.impl;

import com.example.courseenroll.common.Result;
import com.example.courseenroll.dto.EnrollmentDetailDTO;
import com.example.courseenroll.entity.Course;
import com.example.courseenroll.entity.Enrollment;
import com.example.courseenroll.mapper.CourseMapper;
import com.example.courseenroll.mapper.EnrollmentMapper;
import com.example.courseenroll.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrollmentService implements IEnrollmentService {

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    @Transactional
    public Result enroll(Long studentId, Long courseId) {
        if (enrollmentMapper.exists(studentId, courseId)) {
            return Result.fail("已报名该课程");
        }

        Course course = courseMapper.findById(courseId);
        if (course.getRemainingCapacity() <= 0){
            return Result.fail("课程人数已满");
        }
//        int currentCount = courseMapper.countEnrollments(courseId);
//        if (currentCount >= course.getMaxCapacity()) {
//            return Result.fail("课程人数已满");
//        }
        course.setRemainingCapacity(course.getRemainingCapacity() - 1);
        course.setRegisteredCapacity(course.getRegisteredCapacity() + 1);
        courseMapper.update(course);

        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(studentId);
        enrollment.setCourseId(courseId);
        enrollmentMapper.insert(enrollment);
        return Result.success("报名成功!");
    }

    @Override
    @Transactional
    public Result cancelEnroll(Long studentId, Long courseId) {
        if (!enrollmentMapper.exists(studentId, courseId)) {
            return Result.fail("未报名该课程");
        }
        enrollmentMapper.deleteByStudentAndCourse(studentId, courseId);
        Course course = courseMapper.findById(courseId);
        course.setRemainingCapacity(course.getRemainingCapacity() + 1);
        course.setRegisteredCapacity(course.getRegisteredCapacity() - 1);
        courseMapper.update(course);
        return Result.success("取消成功!");
    }

    @Override
    public List<EnrollmentDetailDTO> getEnrollmentsByStudent(Long studentId) {
        return enrollmentMapper.selectEnrollmentsByStudent(studentId);
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {
        enrollmentMapper.deleteEnrollment(enrollmentId);
    }
}