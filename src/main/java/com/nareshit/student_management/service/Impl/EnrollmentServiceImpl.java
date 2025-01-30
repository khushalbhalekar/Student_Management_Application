package com.nareshit.student_management.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nareshit.student_management.dto.EnrollmentDTO;
import com.nareshit.student_management.dto.EnrollmentSaveDTO;
import com.nareshit.student_management.dto.EnrollmentUpdateDTO;
import com.nareshit.student_management.entity.Enrollment;
import com.nareshit.student_management.exception.EnrollmentNotFoundException;
import com.nareshit.student_management.repo.BatchRepo;
import com.nareshit.student_management.repo.EnrollmentRepo;
import com.nareshit.student_management.repo.StudentRepo;
import com.nareshit.student_management.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private BatchRepo batchRepo;

    @SuppressWarnings("deprecation")
	@Override
    public ResponseEntity<Map<String, Object>> addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {
    	Map<String, Object> response = new HashMap<>();
        try {
            Enrollment enrollment = new Enrollment(
                    studentRepo.getById(enrollmentSaveDTO.getStudentId()),
                    batchRepo.getById(enrollmentSaveDTO.getBatchId()),
                    enrollmentSaveDTO.getJoinDate(),
                    enrollmentSaveDTO.getFee()
            );
            enrollmentRepo.save(enrollment);
            response.put("code", 200);
            response.put("status", "success");
            response.put("message","Enrollment added Successfully!");
            response.put("data", enrollment);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
//            throw new RuntimeException("Error while adding enrollment: " + e.getMessage());
        	
            response.put("code", 400);
            response.put("status", "failed");
            response.put("message","No record found");
            response.put("data", null);
            
        	return ResponseEntity.badRequest().body(response);
        }
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        try {
            List<Enrollment> enrollments = enrollmentRepo.findAll();
            List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();
            for (Enrollment enrollment : enrollments) {
                EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
                        enrollment.getEnrollId(),
                        enrollment.getStudent(),
                        enrollment.getBatch(),
                        enrollment.getJoinDate(),
                        enrollment.getFee()
                );
                enrollmentDTOList.add(enrollmentDTO);
            }
            return enrollmentDTOList;
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving enrollments: " + e.getMessage());
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO) {
        try {
            Enrollment enrollment = enrollmentRepo.findById(enrollmentUpdateDTO.getEnrollId()).orElseThrow(
                    () -> new EnrollmentNotFoundException("Enrollment with ID " + enrollmentUpdateDTO.getEnrollId() + " not found.")
            );
            enrollment.setStudent(studentRepo.getById(enrollmentUpdateDTO.getStudentId()));
            enrollment.setBatch(batchRepo.getReferenceById(enrollmentUpdateDTO.getBatchId()));
            enrollment.setJoinDate(enrollmentUpdateDTO.getJoinDate());
            enrollment.setFee(enrollmentUpdateDTO.getFee());
            enrollmentRepo.save(enrollment);
            return enrollment.getJoinDate();
        } catch (EnrollmentNotFoundException e) {
            return e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException("Error while updating enrollment: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteEnrollment(long id) {
        try {
            if (enrollmentRepo.existsById(id)) {
                enrollmentRepo.deleteById(id);
                return true;
            } else {
                throw new EnrollmentNotFoundException("Enrollment with ID " + id + " not found.");
            }
        } catch (EnrollmentNotFoundException e) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting enrollment: " + e.getMessage());
        }
    }
}



/*
 * package com.nareshit.student_management.service.Impl;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.nareshit.student_management.dto.EnrollmentDTO; import
 * com.nareshit.student_management.dto.EnrollmentSaveDTO; import
 * com.nareshit.student_management.dto.EnrollmentUpdateDTO; import
 * com.nareshit.student_management.entity.Enrollment; import
 * com.nareshit.student_management.repo.BatchRepo; import
 * com.nareshit.student_management.repo.EnrollmentRepo; import
 * com.nareshit.student_management.repo.StudentRepo; import
 * com.nareshit.student_management.service.EnrollmentService;
 * 
 * @Service 
 * public class EnrollmentServiceImpl implements EnrollmentService {
 * 
 * @Autowired 
 * private EnrollmentRepo enrollmentRepo;
 * 
 * @Autowired 
 * private StudentRepo studentRepo;
 * 
 * @Autowired 
 * private BatchRepo batchRepo;
 * 
 * @Override 
 * public String addEnrollment(EnrollmentSaveDTO entrollmentSaveDTO)
 * {
 * 
 * @SuppressWarnings("deprecation") 
 * Enrollment enrollment = new Enrollment(
 * studentRepo.getById(entrollmentSaveDTO.getStudentId()),
 * batchRepo.getById(entrollmentSaveDTO.getBatchId()),
 * entrollmentSaveDTO.getJoinDate(), 
 * entrollmentSaveDTO.getFee() 
 * );
 * enrollmentRepo.save(enrollment); 
 * return enrollment.getJoinDate(); 
 * }
 * 
 * @Override 
 * public List<EnrollmentDTO> getAllEnrollments()
 * {
 *   List<Enrollment>
 * getEnrollments = enrollmentRepo.findAll(); List<EnrollmentDTO>
 * enrollmentDTOList = new ArrayList<>(); 
 * for(Enrollment enrollment:getEnrollments) 
 * { 
 * EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
 * enrollment.getEnrollId(), 
 * enrollment.getStudent(), 
 * enrollment.getBatch(),
 * enrollment.getJoinDate(), 
 * enrollment.getFee() 
 * );
 * enrollmentDTOList.add(enrollmentDTO); 
 * } 
 * return enrollmentDTOList; 
 * }
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Override 
 * public String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO)
 *  {
 * if(enrollmentRepo.existsById(enrollmentUpdateDTO.getEnrollId())) 
 * { 
 * Enrollment enrollment = enrollmentRepo.getById(enrollmentUpdateDTO.getEnrollId());
 * 
 * enrollment.setStudent(studentRepo.getById(enrollmentUpdateDTO.getStudentId()));
 * 
 * enrollment.setBatch(batchRepo.getReferenceById(enrollmentUpdateDTO.getBatchId())); 
 * 
 * enrollment.setJoinDate(enrollmentUpdateDTO.getJoinDate());
 * 
 * enrollment.setFee(enrollmentUpdateDTO.getFee());
 * 
 * enrollmentRepo.save(enrollment); 
 * return enrollment.getJoinDate();
 * } 
 * else 
 * {
 * 
 * System.out.println("Enrollment ID Not Found");
 * } 
 * return null; 
 * }
 * 
 * @Override public boolean deleteEnrollment(long id) 
 * {
 * if(enrollmentRepo.existsById(id)) 
 * { 
 * enrollmentRepo.deleteById(id); 
 * } 
 * else
 * {
 * System.out.println("Enrollment ID Not Found"); 
 * } 
 * return false; 
 * } 
 * }
 */