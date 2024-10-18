package com.suryakant.repo_practice.repository;

import com.suryakant.repo_practice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

 @Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "CALL top_earners.highest_salary_earners(:topN)", nativeQuery = true)  // Use 'sury' as the schema name
    List<Employee> findTopSalaryEarners(@Param("topN") int topN);
}
