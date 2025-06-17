package com.employeeapp.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDetailsDTO {
    private Long id;
    private String name;
    private String email;
    private String departmentName;
    private LocalDate dateOfJoining;
    private double salary;
    private String managerName;
    private List<ProjectDTO> projects;
    private List<PerformanceReviewDTO> last3Reviews;
}
