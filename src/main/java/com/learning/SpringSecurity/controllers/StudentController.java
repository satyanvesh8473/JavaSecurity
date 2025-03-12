package com.learning.SpringSecurity.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.SpringSecurity.domain.Student;

@RestController
public class StudentController {

	private List<Student> students;

	public StudentController() {
		students = new ArrayList<>();
		students.add(new Student("anvesh", 24, 100));
		students.add(new Student("satya", 24, 100));
	}

	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/getCsrfToken")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}

	@PostMapping("/saveStudents")
	public List<Student> saveStudents(@RequestBody Student student) {
		students.add(student);
		return students;
	}
}
