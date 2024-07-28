package com.org.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/my-cards")
@RestController
public class MyCards {
 public String hello(){
     return "hello from my-cards";

 }

}
