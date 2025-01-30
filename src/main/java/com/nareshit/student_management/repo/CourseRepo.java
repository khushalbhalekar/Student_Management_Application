package com.nareshit.student_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.student_management.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long>
{

}
