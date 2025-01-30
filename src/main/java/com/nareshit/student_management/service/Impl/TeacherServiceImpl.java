package com.nareshit.student_management.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.student_management.dto.TeacherDTO;
import com.nareshit.student_management.dto.TeacherSaveDTO;
import com.nareshit.student_management.dto.TeacherUpdateDTO;
import com.nareshit.student_management.entity.Teacher;
import com.nareshit.student_management.exception.TeacherNotFoundException;
import com.nareshit.student_management.repo.TeacherRepo;
import com.nareshit.student_management.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {
        try {
            Teacher teacher = new Teacher(teacherSaveDTO.getTeacherName(), teacherSaveDTO.getAddress(), teacherSaveDTO.getPhoneNo());
            teacherRepo.save(teacher);
            return teacher.getTeacherName();
        } catch (Exception e) {
            throw new RuntimeException("Error while adding teacher: " + e.getMessage());
        }
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        try {
            List<Teacher> getTeachers = teacherRepo.findAll();
            List<TeacherDTO> teacherDTOList = new ArrayList<>();
            for (Teacher teacher : getTeachers) {
                TeacherDTO teacherDTO = new TeacherDTO(teacher.getTeacherId(), teacher.getTeacherName(), teacher.getAddress(), teacher.getPhoneNo());
                teacherDTOList.add(teacherDTO);
            }
            return teacherDTOList;
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving teachers: " + e.getMessage());
        }
    }

    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        try {
            Teacher teacher = teacherRepo.findById(teacherUpdateDTO.getTeacherId()).orElseThrow(
                    () -> new TeacherNotFoundException("Teacher with ID " + teacherUpdateDTO.getTeacherId() + " not found.")
            );
            teacher.setTeacherName(teacherUpdateDTO.getTeacherName());
            teacher.setAddress(teacherUpdateDTO.getAddress());
            teacher.setPhoneNo(teacherUpdateDTO.getPhoneNo());
            teacherRepo.save(teacher);
            return teacher.getTeacherName() + " Record Updated Successfully!";
        } catch (TeacherNotFoundException e) {
            return e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException("Error while updating teacher: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteTeacher(long id) {
        try {
            if (teacherRepo.existsById(id)) {
                teacherRepo.deleteById(id);
                return true;
            } else {
                throw new TeacherNotFoundException("Teacher with ID " + id + " not found.");
            }
        } catch (TeacherNotFoundException e) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting teacher: " + e.getMessage());
        }
    }
}




/*
 * package com.nareshit.student_management.service.Impl;
 * 
 * import java.util.ArrayList; import java.util.List; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.nareshit.student_management.dto.TeacherDTO; import
 * com.nareshit.student_management.dto.TeacherSaveDTO; import
 * com.nareshit.student_management.dto.TeacherUpdateDTO; import
 * com.nareshit.student_management.entity.Teacher; import
 * com.nareshit.student_management.repo.TeacherRepo; import
 * com.nareshit.student_management.service.TeacherService;
 * 
 * @Service public class TeacherServiceImpl implements TeacherService {
 * 
 * @Autowired private TeacherRepo teacherRepo;
 * 
 * @Override public String addTeacher(TeacherSaveDTO teacherSaveDTO) { Teacher
 * teacher = new
 * Teacher(teacherSaveDTO.getTeacherName(),teacherSaveDTO.getAddress(),
 * teacherSaveDTO.getPhoneNo()); teacherRepo.save(teacher); return
 * teacher.getTeacherName(); }
 * 
 * @Override public List<TeacherDTO> getAllTeachers() { List<Teacher>
 * getTeachers = teacherRepo.findAll(); List<TeacherDTO> teacherDTOList =new
 * ArrayList<>(); for(Teacher teacher : getTeachers) { TeacherDTO studentDTO =
 * new
 * TeacherDTO(teacher.getTeacherId(),teacher.getTeacherName(),teacher.getAddress
 * (),teacher.getPhoneNo()); teacherDTOList.add(studentDTO); } return
 * teacherDTOList; }
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Override public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
 * if(teacherRepo.existsById(teacherUpdateDTO.getTeacherId())) { Teacher teacher
 * = teacherRepo.getById(teacherUpdateDTO.getTeacherId());
 * teacher.setTeacherName(teacherUpdateDTO.getTeacherName());
 * teacher.setAddress(teacherUpdateDTO.getAddress());
 * teacher.setPhoneNo(teacherUpdateDTO.getPhoneNo()); teacherRepo.save(teacher);
 * return teacher.getTeacherName()+" Record Update Successfully!"; } else {
 * System.out.println("Teacher id - "+teacherUpdateDTO.getTeacherId()
 * +" not found!"); return
 * teacherUpdateDTO.getTeacherId()+" Record Not Updated!"; } }
 * 
 * @Override public boolean deleteTeacher(long id) {
 * if(teacherRepo.existsById(id)) { teacherRepo.deleteById(id); return true; }
 * else { System.out.println("Teacher id - "+id+" not Found!"); return false; }
 * }
 * 
 * }
 */