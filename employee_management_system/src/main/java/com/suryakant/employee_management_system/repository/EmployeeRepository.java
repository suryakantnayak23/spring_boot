package com.suryakant.employee_management_system.repository;

import com.suryakant.employee_management_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
