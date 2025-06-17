package com.employeeapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PerformanceReviewDTO {
    private LocalDate reviewDate;
    private int score;
    private String reviewComments;
}
