package com.employeeapp.controller;

import com.employeeapp.dto.EmployeeDTO;
import com.employeeapp.dto.EmployeeDetailsDTO;
import com.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/filter")
    public List<EmployeeDTO> filterEmployees(
            @RequestParam(required = false) Integer score,
            @RequestParam(required = false) String reviewDate,
            @RequestParam(required = false) List<String> departmentNames,
            @RequestParam(required = false) List<String> projectNames
    ) {
        LocalDate parsedDate = (reviewDate != null) ? LocalDate.parse(reviewDate) : null;
        return employeeService.filterEmployees(score, parsedDate, departmentNames, projectNames);
    }

    @GetMapping("/")
    public EmployeeDetailsDTO getEmployeeById(@RequestParam(required=false) Long id) {
        return employeeService.getEmployeeDetails(id);
    }
}
