package com.nareshit.student_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.student_management.dto.EnrollmentDTO;
import com.nareshit.student_management.dto.EnrollmentSaveDTO;
import com.nareshit.student_management.dto.EnrollmentUpdateDTO;
import com.nareshit.student_management.service.EnrollmentService;


//{
//	  "studentId": 2,
//	  "batchId": 1,
//	  "joinDate": "2025-02-02",
//	  "fee": 3000
//	}

@RestController
@CrossOrigin
@RequestMapping("/entrollment")
public class EnrollmentController 
{
	@Autowired
	private EnrollmentService enrollmentService;

	@PostMapping(path = "/save")
    public ResponseEntity<Map<String, Object>> saveEnrollment(@RequestBody EnrollmentSaveDTO entrollmentSaveDTO)
    {
		ResponseEntity<Map<String, Object>> enrollment = enrollmentService.addEnrollment(entrollmentSaveDTO);
        return enrollment;
    }
    @GetMapping("/getAllEnrollments")
    public List<EnrollmentDTO> getAllEnrollments()
    {
        List<EnrollmentDTO> allEnrollments = enrollmentService.getAllEnrollments();
        return allEnrollments;
    }
    @PutMapping(path = "/update")
    public String updateEnrollment(@RequestBody EnrollmentUpdateDTO enrollmentUpdateDTO)
    {
        String enrollment = enrollmentService.updateEnrollment(enrollmentUpdateDTO);
        return enrollment;
    }
    @SuppressWarnings("unused")
	@DeleteMapping(path = "/delete/{id}")
    public String deleteEnrollment(@PathVariable(value = "id")int id)
    {
        boolean deleteCourse = enrollmentService.deleteEnrollment(id);
        return "Enrollment Record Delete Succesfully!";
    }
}
