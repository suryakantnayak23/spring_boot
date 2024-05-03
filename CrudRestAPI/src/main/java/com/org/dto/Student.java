 package com.org.dto;

import jakarta.persistence.*;

 @Entity
public class Student {

	 @Id
	 // @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "rollNo", length = 13)
	 private Integer rollNo;
	 @Column(name = "name", length = 25)
	 private String name;
	 @Column(name = "age", length = 13)
	 private Integer age;
	 @Column(name = "mobile", length = 9)
	 private long mobile;
	 @Column(name = "course", length = 25)
	 private String course;
	 @Column(name = "email", length = 25)
	 private String email;
	 @Column(name = "password", length = 25)
	 private String password;

	 public long getMobile() {
		 return mobile;
	 }

	 public String getCourse() {
		 return course;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public void setCourse(String course) {
		 this.course = course;
	 }

	 public void setMobile(long mobile) {
		 this.mobile = mobile;
	 }

	 public Integer getRollNo() {
		 return rollNo;
	 }

	 public Integer getAge() {
		 return age;
	 }

	 public void setAge(Integer age) {
		 this.age = age;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public void setRollNo(Integer rollNo) {
		 this.rollNo = rollNo;
	 }

 }


