package com.example.courseenroll.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Integer maxCapacity;
    private String publisherName;
    private String publisherPhone;
    private String publisherJobNumber;
    private String publisherGrade;
    private String publisherClass;
    private Integer delFlag;
    private LocalDateTime createTime;
    private transient boolean enrolled;
}
