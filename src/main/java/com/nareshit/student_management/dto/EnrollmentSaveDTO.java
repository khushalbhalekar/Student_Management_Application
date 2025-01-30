package com.nareshit.student_management.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="entrollment")
public class EnrollmentSaveDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long enrollId;
	private long studentId;
	private long batchId;
	private String joinDate;
	private double fee;
	// public long getEnrollId() {
	// 	return enrollId;
	// }
	// public void setEnrollId(long enrollId) {
	// 	this.enrollId = enrollId;
	// }
	// public long getStudentId() {
	// 	return studentId;
	// }
	// public void setStudentId(long studentId) {
	// 	this.studentId = studentId;
	// }
	// public long getBatchId() {
	// 	return batchId;
	// }
	// public void setBatchId(long batchId) {
	// 	this.batchId = batchId;
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
