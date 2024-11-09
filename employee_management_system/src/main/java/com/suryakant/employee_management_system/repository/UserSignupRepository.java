package com.suryakant.employee_management_system.repository;

import com.suryakant.employee_management_system.model.UserSignup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSignupRepository extends JpaRepository<UserSignup, Long> {
}
