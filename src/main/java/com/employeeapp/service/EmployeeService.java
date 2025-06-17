package com.employeeapp.service;

import com.employeeapp.dto.EmployeeDetailsDTO;
import com.employeeapp.dto.EmployeeDTO;
import com.employeeapp.dto.PerformanceReviewDTO;
import com.employeeapp.dto.ProjectDTO;
import com.employeeapp.model.*;
import com.employeeapp.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PerformanceReviewRepository performanceReviewRepository;

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    public List<EmployeeDTO> filterEmployees(
            Integer score,
            LocalDate reviewDate,
            List<String> departmentNames,
            List<String> projectNames) {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().filter(employee -> {
            boolean departmentMatch = (departmentNames == null || departmentNames.isEmpty()) ||
                    (employee.getDepartment() != null &&
                            departmentNames.contains(employee.getDepartment().getName()));

            boolean projectMatch = (projectNames == null || projectNames.isEmpty()) ||
                    employee.getEmployeeProjects().stream()
                            .map(ep -> ep.getProject().getName())
                            .anyMatch(projectNames::contains);

            boolean performanceMatch = (score == null && reviewDate == null) ||
                    employee.getReviews().stream().anyMatch(r ->
                            (score == null || r.getScore().equals(score)) &&
                                    (reviewDate == null || r.getReviewDate().equals(reviewDate)));

            return departmentMatch && projectMatch && performanceMatch;
        }).map(this::convertToDTO).collect(Collectors.toList());
    }

    public EmployeeDetailsDTO getEmployeeDetails(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new NoSuchElementException("Employee not found");
        }
        Employee employee = optionalEmployee.get();
        return convertToDetailsDTO(employee);
    }


    private EmployeeDTO convertToDTO(Employee e) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setEmail(e.getEmail());
        dto.setSalary(e.getSalary());
        dto.setDateOfJoining(e.getDateOfJoining());
        dto.setDepartmentName(e.getDepartment() != null ? e.getDepartment().getName() : null);
        dto.setManagerName(e.getManager() != null ? e.getManager().getName() : null);
        return dto;
    }

    private EmployeeDetailsDTO convertToDetailsDTO(Employee e) {
        EmployeeDetailsDTO dto = new EmployeeDetailsDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setEmail(e.getEmail());
        dto.setSalary(e.getSalary());
        dto.setDateOfJoining(e.getDateOfJoining());
        dto.setDepartmentName(e.getDepartment() != null ? e.getDepartment().getName() : null);
        dto.setManagerName(e.getManager() != null ? e.getManager().getName() : null);

        List<ProjectDTO> projectDTOs = e.getEmployeeProjects().stream().map(ep -> {
            ProjectDTO p = new ProjectDTO();
            p.setId(ep.getProject().getId());
            p.setName(ep.getProject().getName());
            p.setStartDate(ep.getProject().getStartDate());
            p.setEndDate(ep.getProject().getEndDate());
            p.setRole(ep.getRole());
            p.setAssignedDate(ep.getAssignedDate());
            return p;
        }).collect(Collectors.toList());
        dto.setProjects(projectDTOs);

        List<PerformanceReviewDTO> reviewDTOs = e.getReviews().stream()
                .sorted((r1, r2) -> r2.getReviewDate().compareTo(r1.getReviewDate()))
                .limit(3)
                .map(r -> {
                    PerformanceReviewDTO pr = new PerformanceReviewDTO();
                    pr.setReviewDate(r.getReviewDate());
                    pr.setScore(r.getScore());
                    pr.setReviewComments(r.getReviewComments());
                    return pr;
                }).collect(Collectors.toList());
        dto.setLast3Reviews(reviewDTOs);

        return dto;
    }
}
