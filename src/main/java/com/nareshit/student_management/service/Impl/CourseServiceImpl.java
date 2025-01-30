
package com.nareshit.student_management.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.student_management.dto.CourseDTO;
import com.nareshit.student_management.dto.CourseSaveDTO;
import com.nareshit.student_management.dto.CourseUpdateDTO;
import com.nareshit.student_management.entity.Course;
import com.nareshit.student_management.exception.CourseNotFoundException;
import com.nareshit.student_management.repo.CourseRepo;
import com.nareshit.student_management.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService 
{
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String addCourse(CourseSaveDTO courseSaveDTO) 
    {
        try 
        {
            Course course = new Course(courseSaveDTO.getCourseName(), courseSaveDTO.getCourseSyllabus(), courseSaveDTO.getDuration());
            courseRepo.save(course);
            return course.getCourseName();
        } 
        catch (Exception e) 
        {
            throw new RuntimeException("Error while adding course: " + e.getMessage());
        }
    }

    @Override
    public List<CourseDTO> getAllCourses() 
    {
        try
        {
            List<Course> getCourses = courseRepo.findAll();
            List<CourseDTO> courseDTOList = new ArrayList<>();
            for (Course course : getCourses)
            {
                CourseDTO courseDTO = new CourseDTO(course.getCourseId(), course.getCourseName(), course.getCourseSyllabus(), course.getDuration());
                courseDTOList.add(courseDTO);
            }
            return courseDTOList;
        }
        catch (Exception e) 
        {
            throw new RuntimeException("Error while retrieving all courses: " + e.getMessage());
        }
    }

    @Override
    public String updateCourse(CourseUpdateDTO courseUpdateDTO)
    {
        try
        {
            Course course = courseRepo.findById(courseUpdateDTO.getCourseId()).orElseThrow(
                    () -> new CourseNotFoundException("Course with ID " + courseUpdateDTO.getCourseId() + " not found.")
            );
            course.setCourseName(courseUpdateDTO.getCourseName());
            course.setCourseSyllabus(courseUpdateDTO.getCourseSyllabus());
            course.setDuration(courseUpdateDTO.getDuration());
            courseRepo.save(course);
            return course.getCourseName() + " Record Updated Successfully!";
        } 
        catch (CourseNotFoundException e)
        {
            return e.getMessage();
        } 
        catch (Exception e) 
        {
            throw new RuntimeException("Error while updating course: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteCourse(long id) 
    {
        try
        {
            if (courseRepo.existsById(id))
            {
                courseRepo.deleteById(id);
                return true;
            } 
            else 
            {
                throw new CourseNotFoundException("Course with ID " + id + " not found.");
            }
        } 
        catch (CourseNotFoundException e)
        {
            return false;
        }
        catch (Exception e) 
        {
            throw new RuntimeException("Error while deleting course: " + e.getMessage());
        }
    }
}


//package com.nareshit.student_management.service.Impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nareshit.student_management.dto.CourseDTO;
//import com.nareshit.student_management.dto.CourseSaveDTO;
//import com.nareshit.student_management.dto.CourseUpdateDTO;
//import com.nareshit.student_management.entity.Course;
//import com.nareshit.student_management.repo.CourseRepo;
//import com.nareshit.student_management.service.CourseService;
//
//@Service
//public class CourseServiceImpl implements CourseService {
//
//    @Autowired
//    private CourseRepo courseRepo;
//
//    @Override
//    public String addCourse(CourseSaveDTO courseSaveDTO) {
//        Course course = new Course(courseSaveDTO.getCourseName(), courseSaveDTO.getCourseSyllabus(), courseSaveDTO.getDuration());
//        courseRepo.save(course);
//        return course.getCourseName();
//    }
//
//    @Override
//    public List<CourseDTO> getAllCourses() {
//        List<Course> getCourses = courseRepo.findAll();
//        List<CourseDTO> courseDTOList = new ArrayList<>();
//        for (Course course : getCourses) {
//            CourseDTO courseDTO = new CourseDTO(course.getCourseId(), course.getCourseName(), course.getCourseSyllabus(), course.getDuration());
//            courseDTOList.add(courseDTO);
//        }
//        return courseDTOList;
//    }
//
//    @SuppressWarnings("deprecation")
//    @Override
//    public String updateCourse(CourseUpdateDTO courseUpdateDTO) {
//        if (courseRepo.existsById(courseUpdateDTO.getCourseId())) {
//            Course course = courseRepo.getById(courseUpdateDTO.getCourseId());
//            course.setCourseName(courseUpdateDTO.getCourseName());
//            course.setCourseSyllabus(courseUpdateDTO.getCourseSyllabus());
//            course.setDuration(courseUpdateDTO.getDuration());
//            courseRepo.save(course);
//            return course.getCourseName() + " Record Update Sucessfully!";
//        } else {
//            System.out.println("Course id - " + courseUpdateDTO.getCourseId() + " not found!");
//            return courseUpdateDTO.getCourseId() + " Record Not Updated!";
//        }
//    }
//
//    @Override
//    public boolean deleteCourse(long id) {
//        if (courseRepo.existsById(id)) {
//            courseRepo.deleteById(id);
//            return true;
//        } else {
//            System.out.println("Course id - " + id + " not Found!");
//            return false;
//        }
//    }
//
//}
