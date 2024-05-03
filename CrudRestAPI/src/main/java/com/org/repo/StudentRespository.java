package com.org.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.dto.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRespository extends JpaRepository<Student, Integer> {


	List<Student> findByEmailAndPassword(String email, String password);
	List<Student> findByCourse(String course);
	@Query("SELECT s FROM Student s WHERE s.age >= :minAge")
	List<Student> findByAgeGreaterThan(@Param("minAge") int minAge);
}


