package com.nareshit.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.student_management.dto.StudentDTO;
import com.nareshit.student_management.dto.StudentSaveDTO;
import com.nareshit.student_management.dto.StudentUpdateDTO;
import com.nareshit.student_management.service.StudentService;


@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping(path="/save")
	public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO)
	{
		String sName = studentService.addStudent(studentSaveDTO);
		return sName;
	}
	
	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents() 
	{
		List<StudentDTO> allStudents =studentService.getAllStudents();
		return allStudents;
	}
	
	@PutMapping(path="/update")
	public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO)
	{
		String sName = studentService.updateStudent(studentUpdateDTO);
		return sName;
	}
	@SuppressWarnings("unused")
	@DeleteMapping(path="/delete/{id}")
	public String deleteStudent(@PathVariable(value = "id") long id)
	{
		boolean deleteStudent = studentService.deleteStudent(id);
		return "Record Delete Sucessfully!";
	}
	
}
