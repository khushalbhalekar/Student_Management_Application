package com.nareshit.student_management.service;

import java.util.List;

import com.nareshit.student_management.dto.CourseDTO;
import com.nareshit.student_management.dto.CourseSaveDTO;
import com.nareshit.student_management.dto.CourseUpdateDTO;

public interface CourseService {

	String addCourse(CourseSaveDTO courseSaveDTO);

	List<CourseDTO> getAllCourses();

	boolean deleteCourse(long id);

	String updateCourse(CourseUpdateDTO courseUpdateDTO);

}
