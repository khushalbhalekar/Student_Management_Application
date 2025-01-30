package com.nareshit.student_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Teacher_Id", length = 15)
	private long teacherId;
	
	@Column(name="Teacher_Name", length = 45)
	private String teacherName;
	
	@Column(name="Teacher_Address", length = 100)
	private String address;
	
	@Column(name="Teacher_PhoneNo", length = 12)
	private long phoneNo;

	public Teacher() {
		super();
	}

	public Teacher(String teacherName, String address, long phoneNo) {
		super();
		this.teacherName = teacherName;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public Teacher(long teacherId, String teacherName, String address, long phoneNo) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
	public String toString() 
	{
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", address=" + address
				+ ", phoneNo=" + phoneNo + "]";
	}
}
