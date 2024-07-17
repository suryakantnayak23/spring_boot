package com.org.main.repository;

import com.org.main.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface Repository extends JpaRepository<Employee, Long> {

}
