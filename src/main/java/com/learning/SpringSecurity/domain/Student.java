package com.learning.SpringSecurity.domain;

import lombok.Data;

@Data
public class Student {

	private String name;
	private int age;
	private int marks;
	
	public Student() {
		
	}

	public Student(String name, int age, int marks) {
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
}
