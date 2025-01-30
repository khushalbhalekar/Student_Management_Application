package com.nareshit.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTO 
{
	private long teacherId;
	private String teacherName;	
	private String address;	
	private long phoneNo;
	
	
	// public TeacherDTO(long teacherId, String teacherName, String address, long phoneNo) {
	// 	super();
	// 	this.teacherId = teacherId;
	// 	this.teacherName = teacherName;
	// 	this.address = address;
	// 	this.phoneNo = phoneNo;
	// }
	// public long getTeacherId() {
	// 	return teacherId;
	// }
	// public void setTeacherId(long teacherId) {
	// 	this.teacherId = teacherId;
	// }
	// public String getTeacherName() {
	// 	return teacherName;
	// }
	// public void setTeacherName(String teacherName) {
	// 	this.teacherName = teacherName;
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
