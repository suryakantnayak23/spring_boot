package com.org.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  WelcomeController {


@GetMapping("/hii")
    public String welcome() {
        return "Welcome to Spring Boot";
    }
}
