package com.nareshit.student_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="entrollment")
public class Enrollment 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(length = 11)
	    private long enrollId;
		private long studentId;
		private long batchId;
		private String joinDate;
		private double fee;

	    // @Id
	    // @GeneratedValue(strategy = GenerationType.AUTO)
	    // @Column(name="Enroll_Id",length = 11)
	    // private long enrollId;
	 
	    // @ManyToOne
	    // @JoinColumn(name = "Student_Id",nullable = false)
	    // private Student student;
	    
	    // @ManyToOne
	    // @JoinColumn(name = "Batch_Id",nullable = false)
	    // private Batch batch;
	    
	    // @Column(name="Join_Date",length = 12)
	    // private String joinDate;
	    
	    // @Column(name="Fee",length = 12)
	    // private double fee;
	    
		// public Enrollment() {
		// 	super();
		// }
		// public Enrollment(Student student, Batch batch, String joinDate, double fee) {
		// 	super();
		// 	this.student = student;
		// 	this.batch = batch;
		// 	this.joinDate = joinDate;
		// 	this.fee = fee;
		// }
		// public Enrollment(long enrollId, Student student, Batch batch, String joinDate, double fee) {
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
		
		// @Override
		// public String toString() {
		// 	return "Enrollment [enrollId=" + enrollId + ", student=" + student + ", batch=" + batch + ", joinDate="
		// 			+ joinDate + ", fee=" + fee + "]";
		// }
}
