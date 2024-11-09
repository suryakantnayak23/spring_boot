package com.suryakant.employee_management_system.repository;

import com.suryakant.employee_management_system.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
