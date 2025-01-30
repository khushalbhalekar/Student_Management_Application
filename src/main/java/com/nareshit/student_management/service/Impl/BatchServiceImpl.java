package com.nareshit.student_management.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.student_management.dto.BatchDTO;
import com.nareshit.student_management.dto.BatchSaveDTO;
import com.nareshit.student_management.dto.BatchUpdateDTO;
import com.nareshit.student_management.entity.Batch;
import com.nareshit.student_management.exception.BatchNotFoundException;
import com.nareshit.student_management.repo.BatchRepo;
import com.nareshit.student_management.repo.CourseRepo;
import com.nareshit.student_management.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepo batchRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String addBatch(BatchSaveDTO batchSaveDTO) 
    {
        try 
        {
            Batch batch = new Batch(batchSaveDTO.getBatchName(), batchSaveDTO.getStartDate(),
                    courseRepo.findById(batchSaveDTO.getCourseId()).orElseThrow(
                            () -> new BatchNotFoundException("Course with ID " + batchSaveDTO.getCourseId() + " not found.")
                    ));
            batchRepo.save(batch);
            return batch.getBatchName();
        } 
        catch (Exception e) 
        {
            System.err.println("Error while adding batch: " + e.getMessage());
            throw new RuntimeException("Error while adding batch: " + e.getMessage());
        }
    }

    @Override
    public List<BatchDTO> getAllBatchs() 
    {
        try 
        {
            List<Batch> getBatchs = batchRepo.findAll();
            List<BatchDTO> batchDTOList = new ArrayList<>();
            for (Batch batch : getBatchs)
            {
                BatchDTO batchDTO = new BatchDTO(batch.getBatchId(), batch.getBatchName(), batch.getCourse(),
                        batch.getStartDate());
                batchDTOList.add(batchDTO);
            }
            return batchDTOList;
        } 
        catch (Exception e) {
            System.err.println("Error while retrieving all batches: " + e.getMessage());
            throw new RuntimeException("Error while retrieving all batches: " + e.getMessage());
        }
    }

    @Override
    public String updateBatch(BatchUpdateDTO batchUpdateDTO) 
    {
        try
        {
            Batch batch = batchRepo.findById(batchUpdateDTO.getBatchId()).orElseThrow(
                    () -> new BatchNotFoundException("Batch with ID " + batchUpdateDTO.getBatchId() + " not found.")
            );
            batch.setBatchName(batchUpdateDTO.getBatchName());
            batch.setCourse(courseRepo.findById(batchUpdateDTO.getCourseId()).orElseThrow(
                    () -> new BatchNotFoundException("Course with ID " + batchUpdateDTO.getCourseId() + " not found.")
            ));
            batch.setStartDate(batchUpdateDTO.getStartDate());
            batchRepo.save(batch);
            return batch.getBatchName() + " Record Updated Successfully!";
        } 
        catch (BatchNotFoundException e) 
        {
            System.err.println(e.getMessage());
            return e.getMessage();
        } 
        catch (Exception e) 
        {
        	System.err.println("Error while updating batch: " + e.getMessage());
            throw new RuntimeException("Error while updating batch: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteBatch(long id)
    {
        try 
        {
            if (batchRepo.existsById(id)) {
                batchRepo.deleteById(id);
                return true;
            } else {
                throw new BatchNotFoundException("Batch with ID " + id + " not found.");
            }
        } 
        catch (BatchNotFoundException e) 
        {
            System.err.println(e.getMessage());
            return false;
        } 
        catch (Exception e)
        {
            System.err.println("Error while deleting batch: " + e.getMessage());
            throw new RuntimeException("Error while deleting batch: " + e.getMessage());
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
//import com.nareshit.student_management.dto.BatchDTO;
//import com.nareshit.student_management.dto.BatchSaveDTO;
//import com.nareshit.student_management.dto.BatchUpdateDTO;
//import com.nareshit.student_management.entity.Batch;
//import com.nareshit.student_management.repo.BatchRepo;
//import com.nareshit.student_management.repo.CourseRepo;
//import com.nareshit.student_management.service.BatchService;
//
//@Service
//public class BatchServiceImpl implements BatchService
//{	
//	@Autowired
//	private BatchRepo batchRepo;
//	
//	@Autowired
//	private CourseRepo courseRepo;
//	
//	@SuppressWarnings("deprecation")
//	@Override
//	public String addBatch(BatchSaveDTO batchSaveDTO) 
//	{
//		 Batch batch = new Batch(batchSaveDTO.getBatchName(),batchSaveDTO.getStartDate(),courseRepo.getById(batchSaveDTO.getCourseId()));
//		 batchRepo.save(batch);
//		return batch.getBatchName();
//	}
//
//	@Override
//	public List<BatchDTO> getAllBatchs() 
//	{
//		List<Batch> getBatchs = batchRepo.findAll();
//		List<BatchDTO> batchDTOList =new ArrayList<>();
//		for(Batch batch : getBatchs)
//		{
//			BatchDTO batchDTO = new BatchDTO(batch.getBatchId(),batch.getBatchName(),batch.getCourse(),batch.getStartDate());
//			batchDTOList.add(batchDTO);
//		}
//		return batchDTOList;
//	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public String updateBatch(BatchUpdateDTO batchUpdateDTO)
//	{
//		if(batchRepo.existsById(batchUpdateDTO.getBatchId()))
//		{
//			Batch batch = batchRepo.getById(batchUpdateDTO.getBatchId());
//            batch.setBatchName(batchUpdateDTO.getBatchName());
//            batch.setCourse(courseRepo.getById(batchUpdateDTO.getCourseId()));
//            batch.setStartDate(batchUpdateDTO.getStartDate());
//            batchRepo.save(batch);	
//			return batch.getBatchName()+" Record Update Successfully!";
//		}
//		else
//		{
//			System.out.println("Batch id - "+batchUpdateDTO.getCourseId()+" not found!");
//			return batchUpdateDTO.getBatchId()+" Record Not Updated!";
//		}
//	}
//
//	@Override
//	public boolean deleteBatch(long id)
//	{
//		if(batchRepo.existsById(id))
//		{
//			batchRepo.deleteById(id);
//			return true;
//		}
//		else
//		{
//			System.out.println("Batch id - "+id+" not Found!");
//			return false;
//		}	
//	}
//
//} 


/*
 * package com.nareshit.student_management.service.Impl;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.nareshit.student_management.dto.BatchDTO; import
 * com.nareshit.student_management.dto.BatchSaveDTO; import
 * com.nareshit.student_management.dto.BatchUpdateDTO; import
 * com.nareshit.student_management.entity.Batch; import
 * com.nareshit.student_management.repo.BatchRepo; import
 * com.nareshit.student_management.repo.CourseRepo; import
 * com.nareshit.student_management.service.BatchService;
 * 
 * @Service public class BatchServiceImpl implements BatchService {
 * 
 * @Autowired private BatchRepo batchRepo;
 * 
 * @Autowired private CourseRepo courseRepo;
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Override public String addBatch(BatchSaveDTO batchSaveDTO) { Batch batch =
 * new Batch(batchSaveDTO.getBatchName(),batchSaveDTO.getStartDate(),courseRepo.
 * getById(batchSaveDTO.getCourseId())); batchRepo.save(batch); return
 * batch.getBatchName(); }
 * 
 * @Override public List<BatchDTO> getAllBatchs() { List<Batch> getBatchs =
 * batchRepo.findAll(); List<BatchDTO> batchDTOList =new ArrayList<>();
 * for(Batch batch : getBatchs) { BatchDTO batchDTO = new
 * BatchDTO(batch.getBatchId(),batch.getBatchName(),batch.getCourse(),batch.
 * getStartDate()); batchDTOList.add(batchDTO); } return batchDTOList; }
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Override public String updateBatch(BatchUpdateDTO batchUpdateDTO) {
 * if(batchRepo.existsById(batchUpdateDTO.getBatchId())) { Batch batch =
 * batchRepo.getById(batchUpdateDTO.getBatchId());
 * batch.setBatchName(batchUpdateDTO.getBatchName());
 * batch.setCourse(courseRepo.getById(batchUpdateDTO.getCourseId()));
 * batch.setStartDate(batchUpdateDTO.getStartDate()); batchRepo.save(batch);
 * return batch.getBatchName()+" Record Update Successfully!"; } else {
 * System.out.println("Batch id - "+batchUpdateDTO.getCourseId()+" not found!");
 * return batchUpdateDTO.getBatchId()+" Record Not Updated!"; } }
 * 
 * @Override public boolean deleteBatch(long id) { if(batchRepo.existsById(id))
 * { batchRepo.deleteById(id); return true; } else {
 * System.out.println("Batch id - "+id+" not Found!"); return false; } }
 * 
 * }
 */