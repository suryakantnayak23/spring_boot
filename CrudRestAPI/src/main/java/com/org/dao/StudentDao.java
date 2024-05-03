package com.org.dao;

import java.util.List;
import java.util.Optional;

import javax.print.DocFlavor.READER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.org.dto.Student;
import com.org.repo.StudentRespository;

@Component
public class StudentDao {

	@Autowired
	private StudentRespository repo;

	public ResponseEntity<List<Student> >saveStudent(List<Student> l) {
		List<Student> save = repo.saveAll(l);
		return new ResponseEntity<List<Student>>(save, HttpStatus.OK);
	}

	public ResponseEntity<Student> fetchStudentId(Integer id) {

		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent()) {
			return new ResponseEntity<Student>(optional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<List<Student>> fetchAllStudent() {
		return new ResponseEntity<List<Student>>(repo.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<Student> deleteStudentById(Integer id) {
		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent()) {

			repo.deleteById(id);
			return new ResponseEntity<Student>(optional.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Student> updateById(Integer id, Student student) {

		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent()) {
			student.setRollNo(id);

			Student save = repo.save(student);
			return new ResponseEntity<Student>(save, HttpStatus.OK);

		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<List<Student>> getStudentByEmailAndPassword(String email, String password) {
		 List<Student> list = repo.findByEmailAndPassword(email, password);
		 
		 return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}

	public ResponseEntity<List<Student>> getStudentByCourse(String course) {
		List<Student> list = repo.findByCourse(course);
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
}
