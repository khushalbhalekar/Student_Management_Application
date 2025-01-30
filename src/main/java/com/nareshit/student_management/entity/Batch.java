package com.nareshit.student_management.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Batch")
public class Batch 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Batch_Id", length = 15)
	private long batchId;
	
	@Column(name="Batch_Name", length = 45)
	private String batchName;
	
	@Column(name="Start_Date", length = 30)
	private String startDate;

	@ManyToOne
	@JoinColumn(name="Course_Id", nullable = false )
	private Course course;
	
	 @OneToMany(mappedBy = "batch")
	 private Set<Enrollment> entrollments;

	
	
	public Batch() 
	{
		super();
	}
	public Batch(String batchName, String startDate, Course course) {
		super();
		this.batchName = batchName;
		this.startDate = startDate;
		this.course = course;
	}
	public Batch(long batchId, String batchName, String startDate, Course course) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.startDate = startDate;
		this.course = course;
	}
	public long getBatchId() {
		return batchId;
	}
	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	


}
