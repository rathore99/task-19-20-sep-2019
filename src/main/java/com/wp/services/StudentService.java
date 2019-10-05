package com.wp.services;

import java.util.List;

import com.wp.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);
	public Student deleteStudent(Student student);
	public void updateStudent(Student student);
	public Student searchStudent(int rollNo);
	public List<Student> show();

}
