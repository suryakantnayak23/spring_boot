package com.suryakant.employee_management_system.controller;

import com.suryakant.employee_management_system.model.Company;
import com.suryakant.employee_management_system.repository.CompanyRepository;
import com.suryakant.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    // GET endpoint to retrieve all companies
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // POST endpoint to add a new company
    @PostMapping("/insert-employee-details")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company savedCompany = companyRepository.save(company);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }
}
