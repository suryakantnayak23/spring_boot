package com.suryakant.repo_practice.service;

import com.suryakant.repo_practice.model.Employee;
import com.suryakant.repo_practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getTopSalaryEarners(int topN) {
        return employeeRepository.findTopSalaryEarners(topN);
    }
}
