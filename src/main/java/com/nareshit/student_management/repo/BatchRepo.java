package com.nareshit.student_management.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.student_management.entity.Batch;

public interface BatchRepo extends JpaRepository<Batch , Long>
{

}
