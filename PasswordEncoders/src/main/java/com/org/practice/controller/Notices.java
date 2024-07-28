package com.org.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/notices")
@RestController
public class Notices {
    @GetMapping
    public String hello(){
        return "hello from notices";
    }
}