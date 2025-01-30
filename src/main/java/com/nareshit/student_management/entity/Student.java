package com.nareshit.student_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Student_Id", length = 15)
	private long studentId;
	
	@Column(name="Student_Name", length = 45)
	private String studentName;
	
	@Column(name="Student_Address", length = 100)
	private String address;
	
	@Column(name="Student_PhoneNo", length = 12)
	private long phoneNo;

	public Student() 
	{
		super();
	}

	public Student(long studentId, String studentName, String address, long phoneNo) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public Student(String studentName, String address, long phoneNo) {
		super();
		this.studentName = studentName;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address
				+ ", phoneNo=" + phoneNo + "]";
	}
	
	
}
