package com.nareshit.student_management.service;

import java.util.List;

import com.nareshit.student_management.dto.StudentDTO;
import com.nareshit.student_management.dto.StudentSaveDTO;
import com.nareshit.student_management.dto.StudentUpdateDTO;

public interface StudentService 
{
	String addStudent(StudentSaveDTO studentSaveDTO);
	List<StudentDTO> getAllStudents();
	String updateStudent(StudentUpdateDTO studentUpdateDTO);
	boolean deleteStudent(long id);
}
