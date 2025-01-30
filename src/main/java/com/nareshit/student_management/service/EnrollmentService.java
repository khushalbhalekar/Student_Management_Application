package com.nareshit.student_management.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.nareshit.student_management.dto.EnrollmentDTO;
import com.nareshit.student_management.dto.EnrollmentSaveDTO;
import com.nareshit.student_management.dto.EnrollmentUpdateDTO;

public interface EnrollmentService {
	ResponseEntity<Map<String, Object>> addEnrollment(EnrollmentSaveDTO entrollmentSaveDTO);

	List<EnrollmentDTO> getAllEnrollments();

	String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO);

	boolean deleteEnrollment(long id);

}
