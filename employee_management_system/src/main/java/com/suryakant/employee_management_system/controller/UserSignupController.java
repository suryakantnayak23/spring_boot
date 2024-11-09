package com.suryakant.employee_management_system.controller;

import com.suryakant.employee_management_system.model.UserSignup;
import com.suryakant.employee_management_system.repository.UserSignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
public class UserSignupController {

    @Autowired
    private UserSignupRepository userSignupRepository;

    @PostMapping("/create")
    public ResponseEntity<UserSignup> createSignup(@RequestBody UserSignup userSignup) {
        UserSignup savedUserSignup = userSignupRepository.save(userSignup);
        return ResponseEntity.ok(savedUserSignup);
    }
}
