package com.nareshit.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.student_management.dto.BatchDTO;
import com.nareshit.student_management.dto.BatchSaveDTO;
import com.nareshit.student_management.dto.BatchUpdateDTO;
import com.nareshit.student_management.service.BatchService;

/*//Insertion of data through PostMan
	 {
	  "batchName": "Batch 2025A",
	  "startDate": "2025-02-01",
	  "courseId": 1
	}

 */
@RestController
@CrossOrigin
@RequestMapping("/batch")
public class BatchController 
{
	@Autowired 
	private BatchService batchService;
	
	@PostMapping(path="/save")
	public String saveBatch(@RequestBody BatchSaveDTO batchSaveDTO)
	{
		String batchName = batchService.addBatch(batchSaveDTO);
		return batchName;
	}
	
	@GetMapping("/getAllBatches")
	public List<BatchDTO> getAllBatchs() 
	{
		List<BatchDTO> allBatchs =batchService.getAllBatchs();
		return allBatchs;
	}
	
	@PutMapping(path="/update")
	public String updateBatch(@RequestBody BatchUpdateDTO batchUpdateDTO)
	{
		String batchName = batchService.updateBatch(batchUpdateDTO);
		return batchName;
	}
	@SuppressWarnings("unused")
	@DeleteMapping(path="/delete/{id}")
	public String deleteBatch(@PathVariable(value = "id") long id)
	{
		boolean deleteBatch = batchService.deleteBatch(id);
		return "Batch Record Delete Sucessfully!";
	}

}
