package com.nareshit.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO 
{
	private long studentId;
	private String studentName;	
	private String address;	
	private long phoneNo;
	
	
	// public StudentDTO(long studentId, String studentName, String address, long phoneNo) {
	// 	super();
	// 	this.studentId = studentId;
	// 	this.studentName = studentName;
	// 	this.address = address;
	// 	this.phoneNo = phoneNo;
	// }
	// public long getStudentId() {
	// 	return studentId;
	// }
	// public void setStudentId(long studentId) {
	// 	this.studentId = studentId;
	// }
	// public String getStudentName() {
	// 	return studentName;
	// }
	// public void setStudentName(String studentName) {
	// 	this.studentName = studentName;
	// }
	// public String getAddress() {
	// 	return address;
	// }
	// public void setAddress(String address) {
	// 	this.address = address;
	// }
	// public long getPhoneNo() {
	// 	return phoneNo;
	// }
	// public void setPhoneNo(long phoneNo) {
	// 	this.phoneNo = phoneNo;
	// }
	
}
