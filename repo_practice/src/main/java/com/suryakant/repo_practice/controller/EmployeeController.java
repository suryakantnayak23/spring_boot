package com.suryakant.repo_practice.controller;

import com.suryakant.repo_practice.model.Employee;
import com.suryakant.repo_practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {
        Employee registeredEmployee = employeeService.registerEmployee(employee);
        return ResponseEntity.ok(registeredEmployee);
    }

    @GetMapping("/top-salaries/{topN}")
    public ResponseEntity<List<Employee>> getTopSalaries(@PathVariable int topN) {
        List<Employee> topEmployees = employeeService.getTopSalaryEarners(topN);
        return ResponseEntity.ok(topEmployees);
    }
}
