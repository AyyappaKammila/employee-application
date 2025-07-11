package com.employeeapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String departmentName;
    private LocalDate dateOfJoining;
    private double salary;
    private String managerName;
//
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    public String getDepartmentName() {
//        return departmentName;
//    }
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//    public double getSalary() {
//        return salary;
//    }
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//    public String getManagerName() {
//        return managerName;
//    }
//    public void setManagerName(String managerName) {
//        this.managerName = managerName;
//    }
}
