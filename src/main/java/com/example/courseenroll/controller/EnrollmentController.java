package com.example.courseenroll.controller;

import com.example.courseenroll.entity.Course;
import com.example.courseenroll.service.CourseService;
import com.example.courseenroll.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/courses")
    public List<Course> listCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/enroll")
    public Map<String, Object> enroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        String msg = enrollmentService.enroll(studentId, courseId);
        boolean success = msg.equals("报名成功");
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("message", msg);
        return map;
    }

    @DeleteMapping("/enroll")
    public Map<String, Object> cancelEnroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        String msg = enrollmentService.cancelEnroll(studentId, courseId);
        boolean success = msg.equals("取消成功");
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("message", msg);
        return map;
    }

    @GetMapping("/my-courses")
    public List<Course> getMyCourses(@RequestParam Long studentId) {
        // 需要新增一个方法：根据 studentId 查询已报名课程
        return courseService.getEnrolledCoursesByStudent(studentId);
    }
}