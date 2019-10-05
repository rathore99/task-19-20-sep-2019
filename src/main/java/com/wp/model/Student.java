package com.wp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student {
	
	@Id
	private int rollNo;
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student(int rollNo, String name, String email) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.email = email;
	}
	public Student() {
		super();
	}
	

}
