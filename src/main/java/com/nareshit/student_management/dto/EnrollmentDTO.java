package com.nareshit.student_management.dto;

import com.nareshit.student_management.entity.Batch;
import com.nareshit.student_management.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentDTO
{
	private long enrollId;
	private Student student;
	private Batch batch;
	private String joinDate;
	private double fee;
	// public EnrollmentDTO() {
	// 	super();
	// }
	// public EnrollmentDTO(Student student, Batch batch, String joinDate, double fee) {
	// 	super();
	// 	this.student = student;
	// 	this.batch = batch;
	// 	this.joinDate = joinDate;
	// 	this.fee = fee;
	// }
	
	// public EnrollmentDTO(long enrollId, Student student, Batch batch, String joinDate, double fee) {
	// 	super();
	// 	this.enrollId = enrollId;
	// 	this.student = student;
	// 	this.batch = batch;
	// 	this.joinDate = joinDate;
	// 	this.fee = fee;
	// }
	// public long getEnrollId() {
	// 	return enrollId;
	// }
	// public void setEnrollId(long enrollId) {
	// 	this.enrollId = enrollId;
	// }
	// public Student getStudent() {
	// 	return student;
	// }
	// public void setStudent(Student student) {
	// 	this.student = student;
	// }
	// public Batch getBatch() {
	// 	return batch;
	// }
	// public void setBatch(Batch batch) {
	// 	this.batch = batch;
	// }
	// public String getJoinDate() {
	// 	return joinDate;
	// }
	// public void setJoinDate(String joinDate) {
	// 	this.joinDate = joinDate;
	// }
	// public double getFee() {
	// 	return fee;
	// }
	// public void setFee(double fee) {
	// 	this.fee = fee;
	// }
	
}
