package com.wp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.model.Student;
import com.wp.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	
	//to show registration form
	@RequestMapping(value="registerStudent", method=RequestMethod.GET)
	public ModelAndView showRegistrationForm() {
		ModelAndView modelAndView = new ModelAndView("addStudent");
		modelAndView.addObject("student",new Student());
		return modelAndView;
	}
	
	// to show searchform
	@RequestMapping(value="searchStudent", method=RequestMethod.GET)
	public ModelAndView showSearchForm() {
		ModelAndView modelAndView = new ModelAndView("searchStudent");
		modelAndView.addObject("operationName","search");
		return modelAndView;
	}
	
	// to show updateform
	@RequestMapping(value="updateStudent", method=RequestMethod.GET)
	public ModelAndView showUpdateForm() {
		
		ModelAndView modelAndView = new ModelAndView("searchStudent");
		modelAndView.addObject("operationName","Update");
		return modelAndView;
	}
	//for delete
	@RequestMapping(value="deleteStudent", method=RequestMethod.GET)
	public ModelAndView showDeletionForm() {
		ModelAndView modelAndView = new ModelAndView("deleteStudent");
		modelAndView.addObject("operationName","delete");
		Student student = new Student();
		modelAndView.addObject("student", student);
		List<Student>data =  studentService.show();
		modelAndView.addObject("studentList",data);
		return modelAndView;
	}
	
	@RequestMapping(value="showStudents", method=RequestMethod.GET)
	public ModelAndView showStudentsForm() {
		ModelAndView modelAndView = new ModelAndView("viewAllStudent");
		List<Student>data = studentService.show();
		modelAndView.addObject("studentList", data);
		Student student= new Student();
		modelAndView.addObject("student",student);
		return modelAndView;
	}
	//to add student
	@RequestMapping(value="saveStudent", method=RequestMethod.POST)
	public ModelAndView saveStudentDetail(@Valid @ModelAttribute("student") Student student, BindingResult result
			) {
		if(result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("addStudent");
			return modelAndView;
		}
		studentService.addStudent(student);
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("message", "Student record added successfully");
		modelAndView.addObject("student1", student);
		return modelAndView;
	}
	// to update value
	@RequestMapping(value="updateRecord", method=RequestMethod.POST)
	public ModelAndView updateStudentDetail(@Valid @ModelAttribute("student") Student student, BindingResult result
			) {
		if(result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("updateStudent");
			return modelAndView;
		}
		studentService.updateStudent(student);
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("student1",student);
		modelAndView.addObject("message", "Student record updated successfully");
		return modelAndView;
	}
	//form with values to be updated
	@RequestMapping(value="Update", method=RequestMethod.POST)
	public ModelAndView updateStudentDetail(@RequestParam("rollNo") int rollNo) {
		ModelAndView modelAndView = new ModelAndView("updateStudent");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+rollNo);
		Student student1 = studentService.searchStudent(rollNo);
		modelAndView.addObject("student1", student1);
		return modelAndView;
	}
	@RequestMapping(value="search", method=RequestMethod.POST)
	public ModelAndView searchStudentDetail(@RequestParam("rollNo") int rollNo) {
		ModelAndView modelAndView = new ModelAndView("success");
			Student student1 = studentService.searchStudent(rollNo);
		modelAndView.addObject("student1", student1);
		return modelAndView;
		
	}
	

	@RequestMapping(value="delete", method=RequestMethod.POST)
	public ModelAndView deleteStudentDetail(@RequestParam("rollNo") int rollNo) {
		ModelAndView modelAndView = new ModelAndView("success");
	
		Student student1 = studentService.searchStudent(rollNo);
		System.out.println(student1);
		studentService.deleteStudent(student1);
		modelAndView.addObject("message", "Below Student record deleted successfully");
		modelAndView.addObject("student1", student1);
		return modelAndView;
		
	}
	
	
	/*
	//SEARCH OF userS
		@RequestMapping(value="findUser",method=RequestMethod.GET)
		public ModelAndView findUser(){
			System.out.println("@@@@@@@@@@@@@finduser IS CALLED@@@@@@@@@@@@@@");
			ModelAndView mv = new ModelAndView("searchUser");
			boolean result = true;
			User user = new User();
			mv.addObject("user",user);
			mv.addObject("result",result);
			return mv;
		}


		@RequestMapping("SearchForm")
		public ModelAndView searchuser(@Valid @ModelAttribute("user") User user,BindingResult res){
			System.out.println("@@@@@@@@@@@@@searchuser IS CALLED@@@@@@@@@@@@@@");
			System.out.println(user);
			String text = user.getName();
			ModelAndView mv = new ModelAndView("searchuser");
			boolean result = true;
			if(res.hasFieldErrors("name")){
				System.out.println(res);
				mv.addObject("result",result);
				return mv;
			}
			else{
				result =false;
				List<user> list = userService.searchuser(text);	
				mv.addObject("list",list);
				mv.addObject("result",result);
				return mv;
			}
		}


		//VIEWS OF userS
		@RequestMapping("getAllusers")
		public ModelAndView getAlluser(){
			System.out.println("@@@@@@@@@@@@@getAlluser IS CALLED@@@@@@@@@@@@@@");
			List<user> list = userService.getAlluser();
			ModelAndView mv = new ModelAndView("viewAlluser");
			mv.addObject("list",list);
			return mv;
		}

		//UDPATION OF userS
		@RequestMapping("updateuser")
		public ModelAndView updateuser(@RequestParam("roll") int roll){
			System.out.println("@@@@@@@@@@@@@updateuser IS CALLED@@@@@@@@@@@@@@");
			ModelAndView mv = new ModelAndView("updateuser");
			if(roll>=0){
				user user = userService.getuserByRoll(roll);
				mv.addObject("user",user);
			}
			boolean result = true;
			mv.addObject("result",result);
			return mv;
		}

		@RequestMapping("changeuser")
		public ModelAndView changeuser(){
			System.out.println("@@@@@@@@@@@@@changeuser IS CALLED@@@@@@@@@@@@@@");
			ModelAndView mv = new ModelAndView("updateuser");
			boolean result = true;
			 user user = new user();
			mv.addObject("user",user);
			mv.addObject("result",result);
			return mv;
		}

		@RequestMapping("UpdationForm")
		public ModelAndView updateuser(@ModelAttribute("user") user user){
			System.out.println("@@@@@@@@@@@@@updateuser IS CALLED@@@@@@@@@@@@@@");
			System.out.println(user);
			userService.updateuser(user);
			ModelAndView mv=new ModelAndView("updateuser");
			mv.addObject("result",false);
			mv.addObject("user",user);
			return mv;
		}


		//DELETION OF userS
		@RequestMapping("removeuser")
		public ModelAndView removeuser(){
			System.out.println("@@@@@@@@@@@@@removeuser IS CALLED@@@@@@@@@@@@@@");
			ModelAndView mv = new ModelAndView("deleteuser");
			user user = new user();
			mv.addObject("user",user);
			List<user> list = userService.getAlluser();
			mv.addObject("list",list);
			boolean result = true;
			mv.addObject("result",result);
			return mv;
		}

		@RequestMapping("deletionuser")
		public ModelAndView deleteuser(@ModelAttribute("user") user user){
			System.out.println("@@@@@@@@@@@@@deleteuser IS CALLED@@@@@@@@@@@@@@");
			ModelAndView mv = new ModelAndView("redirect:removeuser");
			user = userService.getuserByRoll(user.getRollno());
			System.out.println("@@@@user FETCHED FOR DEWLETION IS :"+user);
			userService.deleteuser(user);
			boolean result = false;
			mv.addObject("data",user);
			mv.addObject("result",result);
			return mv;
		}
		}
	}*/
}
