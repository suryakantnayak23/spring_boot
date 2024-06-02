package com.example.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	
	static ArrayList<User> users = new ArrayList<User>();
	static {
		users.add(new User(1,"biswajit","2312"));
	}
	
	@GetMapping("/msg")
	public String msg(HttpServletRequest req) {
		
		return "Hello WOlrd "+req.getSession().getId();
	}
	
	@GetMapping("/msg2")
	public String msg2(HttpServletRequest req) {
		
		return "Message "+req.getSession().getId();
	}
	
	@GetMapping("/fetchAll")
	public List<User> fetchAll() {
		
		return users;
	}
	
	@GetMapping("csrf-token")
	public CsrfToken generateCsrf(HttpServletRequest session) {
		
		return (CsrfToken)session.getAttribute("_csrf");
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		
		users.add(user);
		
		return user;
	}
	
	

}
