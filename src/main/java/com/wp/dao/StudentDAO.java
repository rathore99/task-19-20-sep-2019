package com.wp.dao;

import java.util.List;

import com.wp.model.Student;

public interface StudentDAO {
	public Student addStudent(Student student);
	public Student deleteStudent(Student student);
	public Student searchStudent(int rollNo);
	public List<Student>getStudentList();
	public void updateStudent(Student student);

}
