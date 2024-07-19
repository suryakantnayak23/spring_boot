package com.org.main.controller;

import com.org.main.model.Employee;
import com.org.main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/management")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/msg")
    public String msg() {
        return "Hello World";
    }

    @PostMapping("/save")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveAll(employees);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
