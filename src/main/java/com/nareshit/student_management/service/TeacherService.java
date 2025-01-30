package com.nareshit.student_management.service;

import java.util.List;

import com.nareshit.student_management.dto.TeacherDTO;
import com.nareshit.student_management.dto.TeacherSaveDTO;
import com.nareshit.student_management.dto.TeacherUpdateDTO;

public interface TeacherService 
{

	String addTeacher(TeacherSaveDTO teacherSaveDTO);

	List<TeacherDTO> getAllTeachers();

	boolean deleteTeacher(long id);

	String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

}
