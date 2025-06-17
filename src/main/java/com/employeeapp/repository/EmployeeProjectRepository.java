package com.employeeapp.repository;

import com.employeeapp.model.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {
}
