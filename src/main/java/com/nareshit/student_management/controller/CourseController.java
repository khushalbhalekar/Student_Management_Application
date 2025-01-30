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

import com.nareshit.student_management.dto.CourseDTO;
import com.nareshit.student_management.dto.CourseSaveDTO;
import com.nareshit.student_management.dto.CourseUpdateDTO;
import com.nareshit.student_management.service.CourseService;
//{
//"pcourseName":"Full Stack Dot Net",
//"courseName": "Dot Net",
//"duration":"4 Months"
//
//}
@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@PostMapping(path="/save")
	public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO)
	{
		String courseName = courseService.addCourse(courseSaveDTO);
		return courseName;
	}
	
	@GetMapping("/getAllCourses")
	public List<CourseDTO> getAllCourses() 
	{
		List<CourseDTO> allCourses =courseService.getAllCourses();
		return allCourses;
	}
	
	@PutMapping(path="/update")
	public String updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO)
	{
		String courseName = courseService.updateCourse(courseUpdateDTO);
		return courseName;
	}
	@SuppressWarnings("unused")
	@DeleteMapping(path="/delete/{id}")
	public String deleteCourse(@PathVariable(value = "id") long id)
	{
		boolean deleteCourse = courseService.deleteCourse(id);
		return "Record Delete Sucessfully!";
	}
	
}
