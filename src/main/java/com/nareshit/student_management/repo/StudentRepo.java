package com.nareshit.student_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.student_management.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>
{

}
