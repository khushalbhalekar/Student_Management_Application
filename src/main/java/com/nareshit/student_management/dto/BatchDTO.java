package com.nareshit.student_management.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.nareshit.student_management.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDTO 
{
	@SuppressWarnings("unused")
	private long batchId;
	@SuppressWarnings("unused")
	private String batchName;
	@SuppressWarnings("unused")
	private Course course;
	@SuppressWarnings("unused")
	private String startDate;

	// @Autowired
	// public BatchDTO(long batchId, String batchName, Course course, String startDate) {
	// 	super();
	// 	this.batchId = batchId;
	// 	this.batchName = batchName;
	// 	this.course = course;
	// 	this.startDate = startDate;
	// }
	// @Autowired
	// public BatchDTO() {
	// 	super();
	// }
	// public long getBatchId() {
	// 	return batchId;
	// }
	// public void setBatchId(long batchId) {
	// 	this.batchId = batchId;
	// }
	// public String getBatchName() {
	// 	return batchName;
	// }
	// public void setBatchName(String batchName) {
	// 	this.batchName = batchName;
	// }
	// public Course getCourse() {
	// 	return course;
	// }
	// public void setCourse(Course course) {
	// 	this.course = course;
	// }
	// public String getStartDate() {
	// 	return startDate;
	// }
	// public void setStartDate(String startDate) {
	// 	this.startDate = startDate;
	// }
	
	
}
