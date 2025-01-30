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

import com.nareshit.student_management.dto.TeacherDTO;
import com.nareshit.student_management.dto.TeacherSaveDTO;
import com.nareshit.student_management.dto.TeacherUpdateDTO;
import com.nareshit.student_management.service.TeacherService;
//{
//    "teacherId":2,
//	"teacherName":"Ketki",
//    "address":"Nagpur,",
//	"phoneNo":321456987
//	    
//}
@RestController
@CrossOrigin
@RequestMapping("/teacher")

public class TeacherController
{
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping(path="/save")
	public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO)
	{
		String teacherName = teacherService.addTeacher(teacherSaveDTO);
		return teacherName;
	}
	
	@GetMapping("/getAllTeachers")
	public List<TeacherDTO> getAllTeachers() 
	{
		List<TeacherDTO> allTeachers =teacherService.getAllTeachers();
		return allTeachers;
	}
	
	@PutMapping(path="/update")
	public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO)
	{
		String teacherName = teacherService.updateTeacher(teacherUpdateDTO);
		return teacherName;
	}
	@SuppressWarnings("unused")
	@DeleteMapping(path="/delete/{id}")
	public String deleteTeacher(@PathVariable(value = "id") long id)
	{
		boolean deleteTeacher = teacherService.deleteTeacher(id);
		return "Teacher Record Delete Sucessfully!";
	}


}
