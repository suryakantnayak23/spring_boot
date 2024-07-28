package com.org.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/contacts")
@RestController
public class Contacts {
    @GetMapping
    public String hello(){
        return "hello from contacts";
    }
}