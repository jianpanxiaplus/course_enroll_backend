package com.example.courseenroll.controller;

import com.example.courseenroll.common.Result;
import com.example.courseenroll.dto.EnrollmentDetailDTO;
import com.example.courseenroll.req.EnrollmentReq;
import com.example.courseenroll.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enroll")
public class EnrollmentController {

    @Autowired
    private IEnrollmentService enrollmentService;


    @PostMapping("/enroll")
    public Result enroll(@RequestBody EnrollmentReq req) {
        return enrollmentService.enroll(req.getStudentId(), req.getCourseId());
    }

    @DeleteMapping("/cancelEnroll")
    public Result cancelEnroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        return enrollmentService.cancelEnroll(studentId, courseId);
    }

    @GetMapping("/myEnrollments")
    public Result<List<EnrollmentDetailDTO>> getMyEnrollments(@RequestParam("studentId") Long studentId) {
        List<EnrollmentDetailDTO> list = enrollmentService.getEnrollmentsByStudent(studentId);
        return Result.success(list);
    }

    @DeleteMapping("/{enrollmentId}")
    public Result cancelEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.deleteEnrollment(enrollmentId);
        return Result.success("取消成功");
    }

}