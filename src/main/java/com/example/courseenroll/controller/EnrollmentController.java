package com.example.courseenroll.controller;

import com.example.courseenroll.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/enroll")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;


    @PostMapping("/enroll")
    public Map<String, Object> enroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        String msg = enrollmentService.enroll(studentId, courseId);
        boolean success = msg.equals("报名成功");
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("message", msg);
        return map;
    }

    @DeleteMapping("/cancelEnroll")
    public Map<String, Object> cancelEnroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        String msg = enrollmentService.cancelEnroll(studentId, courseId);
        boolean success = msg.equals("取消成功");
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("message", msg);
        return map;
    }

}