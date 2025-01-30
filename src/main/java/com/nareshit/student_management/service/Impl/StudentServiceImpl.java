package com.nareshit.student_management.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.student_management.dto.StudentDTO;
import com.nareshit.student_management.dto.StudentSaveDTO;
import com.nareshit.student_management.dto.StudentUpdateDTO;
import com.nareshit.student_management.entity.Student;
import com.nareshit.student_management.exception.StudentNotFoundException;
import com.nareshit.student_management.repo.StudentRepo;
import com.nareshit.student_management.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        try {
            Student student = new Student(studentSaveDTO.getStudentName(), studentSaveDTO.getAddress(), studentSaveDTO.getPhoneNo());
            studentRepo.save(student);
            return student.getStudentName();
        } catch (Exception e) {
            throw new RuntimeException("Error while adding student: " + e.getMessage());
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        try {
            List<Student> getStudents = studentRepo.findAll();
            List<StudentDTO> studentDTOList = new ArrayList<>();
            for (Student student : getStudents) {
                StudentDTO studentDTO = new StudentDTO(student.getStudentId(), student.getStudentName(), student.getAddress(), student.getPhoneNo());
                studentDTOList.add(studentDTO);
            }
            return studentDTOList;
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving students: " + e.getMessage());
        }
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        try {
            Student student = studentRepo.findById(studentUpdateDTO.getStudentId()).orElseThrow(
                    () -> new StudentNotFoundException("Student with ID " + studentUpdateDTO.getStudentId() + " not found.")
            );
            student.setStudentName(studentUpdateDTO.getStudentName());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhoneNo(studentUpdateDTO.getPhoneNo());
            studentRepo.save(student);
            return student.getStudentName() + " Record Updated Successfully!";
        } catch (StudentNotFoundException e) {
            return e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException("Error while updating student: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteStudent(long id) {
        try {
            if (studentRepo.existsById(id)) {
                studentRepo.deleteById(id);
                return true;
            } else {
                throw new StudentNotFoundException("Student with ID " + id + " not found.");
            }
        } catch (StudentNotFoundException e) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting student: " + e.getMessage());
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
 * import com.nareshit.student_management.dto.StudentDTO; import
 * com.nareshit.student_management.dto.StudentSaveDTO; import
 * com.nareshit.student_management.dto.StudentUpdateDTO; import
 * com.nareshit.student_management.entity.Student; import
 * com.nareshit.student_management.repo.StudentRepo; import
 * com.nareshit.student_management.service.StudentService;
 * 
 * @Service public class StudentServiceImpl implements StudentService {
 * 
 * @Autowired private StudentRepo studentRepo;
 * 
 * @Override public String addStudent(StudentSaveDTO studentSaveDTO) { Student
 * student = new
 * Student(studentSaveDTO.getStudentName(),studentSaveDTO.getAddress(),
 * studentSaveDTO.getPhoneNo()); studentRepo.save(student); return
 * student.getStudentName(); }
 * 
 * @Override public List<StudentDTO> getAllStudents() { List<Student>
 * getStudents = studentRepo.findAll(); List<StudentDTO> studentDTOList =new
 * ArrayList<>(); for(Student student : getStudents) { StudentDTO studentDTO =
 * new
 * StudentDTO(student.getStudentId(),student.getStudentName(),student.getAddress
 * (),student.getPhoneNo()); studentDTOList.add(studentDTO); } return
 * studentDTOList; }
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Override public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
 * if(studentRepo.existsById(studentUpdateDTO.getStudentId())) { Student student
 * = studentRepo.getById(studentUpdateDTO.getStudentId());
 * student.setStudentName(studentUpdateDTO.getStudentName());
 * student.setAddress(studentUpdateDTO.getAddress());
 * student.setPhoneNo(studentUpdateDTO.getPhoneNo()); studentRepo.save(student);
 * return student.getStudentName()+" Record Update Sucessfully!"; } else {
 * System.out.println("Student id - "+studentUpdateDTO.getStudentId()
 * +" not found!"); return
 * studentUpdateDTO.getStudentId()+" Record Not Updated!"; } }
 * 
 * @Override public boolean deleteStudent(long id) {
 * if(studentRepo.existsById(id)) { studentRepo.deleteById(id); return true; }
 * else { System.out.println("Student id - "+id+" not Found!"); return false; }
 * } }
 */