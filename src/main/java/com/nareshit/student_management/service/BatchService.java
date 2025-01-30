package com.nareshit.student_management.service;

import java.util.List;

import com.nareshit.student_management.dto.BatchDTO;
import com.nareshit.student_management.dto.BatchSaveDTO;
import com.nareshit.student_management.dto.BatchUpdateDTO;

public interface BatchService {


	String addBatch(BatchSaveDTO batchSaveDTO);

	List<BatchDTO> getAllBatchs();

	String updateBatch(BatchUpdateDTO batchUpdateDTO);

	boolean deleteBatch(long id);

}
