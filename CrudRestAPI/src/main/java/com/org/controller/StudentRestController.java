package com.org.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.StudentDao;
import com.org.dto.Student;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private StudentDao dao;
	
	@PostMapping
	public ResponseEntity<List<Student>> saveStudent(@RequestBody List<Student> l) {
		return dao.saveStudent(l);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> fetchStudentId(@PathVariable Integer id) {
		return dao.fetchStudentId(id);
	}

	@GetMapping
	public ResponseEntity<List<Student>> fetchAllStudent() {
		return dao.fetchAllStudent();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable Integer id) {
		return dao.deleteStudentById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateById(@PathVariable Integer id,@RequestBody  Student student) {
		return dao.updateById(id, student);
	}
	
	@GetMapping("/{email}/{password}")
	public ResponseEntity<List<Student>> getStudentByEmailAndPassword(String email, String password) {
		 return dao.getStudentByEmailAndPassword(email, password);
		 
	}

	@GetMapping("/course/{course}")
	public ResponseEntity<List<Student>> getStudentByCourse(String course) {
		return dao.getStudentByCourse(course);
	}
}
