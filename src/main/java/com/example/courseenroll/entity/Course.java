package com.example.courseenroll.entity;

import lombok.Data;

@Data
public class Course {
    private Long id;
    private String name;
    private String description;
    private Integer maxCapacity;
}
