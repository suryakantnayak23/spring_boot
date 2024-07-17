package com.org.main.service;

import com.org.main.model.Employee;
import com.org.main.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private Repository repo;

    public List<Employee> saveAll(List<Employee> employees) {
        return repo.saveAll(employees);
    }
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
