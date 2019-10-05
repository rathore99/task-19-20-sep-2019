package com.wp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Student addStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
		return student;
	}

   public Student deleteStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(student);
		tx.commit();
		session.close();
		return student;
	}

	public Student searchStudent(int rollNo) {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class,rollNo);
		tx.commit();
		session.close();
		return student;
		

	}
	public void updateStudent(Student student) {
		Session session =  sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		session.update(student);
		tx.commit();
		session.close();

	}
	
	public List<Student> getStudentList(){
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> data =  criteria.list();
		tx.commit();
		session.close();
		return data;

	}

	

}
