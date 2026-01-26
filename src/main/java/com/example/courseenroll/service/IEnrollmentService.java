package com.example.courseenroll.service;

import com.example.courseenroll.common.Result;
import com.example.courseenroll.dto.EnrollmentDetailDTO;

import java.util.List;

public interface IEnrollmentService {

    Result enroll(Long studentId, Long courseId);
    Result cancelEnroll(Long studentId, Long courseId);
    List<EnrollmentDetailDTO> getEnrollmentsByStudent(Long studentId);
    void deleteEnrollment(Long enrollmentId);
}
