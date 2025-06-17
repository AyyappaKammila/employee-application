package com.employeeapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate assignedDate;
    private String role;
}
