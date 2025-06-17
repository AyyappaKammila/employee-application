package com.employeeapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class PerformanceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate reviewDate;
    private Integer score;
    private String reviewComments;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
