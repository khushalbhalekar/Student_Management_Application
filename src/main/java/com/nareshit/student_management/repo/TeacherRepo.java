package com.nareshit.student_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.student_management.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long>
{

}
