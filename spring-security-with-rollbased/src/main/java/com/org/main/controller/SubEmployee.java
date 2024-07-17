package com.org.main.controller;

import com.org.main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/simple/")
public class SubEmployee {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/msg")
    public String msg() {
        return "Hello World";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
