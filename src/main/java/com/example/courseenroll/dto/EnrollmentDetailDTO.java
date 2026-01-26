package com.example.courseenroll.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EnrollmentDetailDTO {
    private Long enrollmentId;
    private Long courseId;
    private String courseName;
    private Integer publisherGrade;
    private Integer publisherClass;
    private String publisherName;
    private String description;
    private LocalDateTime enrollTime;
}
