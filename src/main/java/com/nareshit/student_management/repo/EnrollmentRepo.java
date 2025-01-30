package com.nareshit.student_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nareshit.student_management.entity.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment , Long>
{

}
