package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.dao.StudentDAO;
import com.wp.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDAO studentDAO;
	public boolean addStudent(Student student) {
	   Student studentObj = studentDAO.addStudent(student);
	   if(studentObj!=null)
		   return true;
		return false;
		
	}
	public Student deleteStudent(Student student) {
	
	return studentDAO.deleteStudent(student);
		
	}
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);	
	}
	public Student searchStudent(int rollNo) {
		return studentDAO.searchStudent(rollNo);
	}
	public List<Student> show() {
	  List<Student>data = studentDAO.getStudentList();
	  return data;
	}

}
