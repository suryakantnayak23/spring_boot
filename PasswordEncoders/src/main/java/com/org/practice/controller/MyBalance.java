package com.org.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-balance")
public class MyBalance {
    public String hello(){
        return "hello from my blnce";

    }
}
