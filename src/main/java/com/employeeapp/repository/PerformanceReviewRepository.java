package com.employeeapp.repository;

import com.employeeapp.model.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {
    List<PerformanceReview> findByEmployeeIdOrderByReviewDateDesc(Long employeeId);

    List<PerformanceReview> findByReviewDateAndScore(LocalDate reviewDate, Integer score);
}
