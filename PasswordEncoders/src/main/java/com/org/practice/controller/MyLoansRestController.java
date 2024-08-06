package com.org.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/my-loans")
@RestController
public class MyLoansRestController {
    @GetMapping
    public String hello(){
        return "hello from my-loans";
    }

    @RequestMapping("/my-cards")
    @RestController
    public static class MyCardsRestController {
        @GetMapping
     public String hello(){
         return "hello from my-cards";

     }

    }
}
