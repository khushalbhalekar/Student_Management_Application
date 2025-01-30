package com.nareshit.student_management.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Course")
public class Course 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Course_Id", length = 15)
	private long courseId;
	
	@Column(name="Course_Name", length = 45)
	private String courseName;
	
	@Column(name="Course_Syllabus", length = 100)
	private String courseSyllabus;
	
	@Column(name="Duration", length = 12)
	private String duration;
	
	@OneToMany(mappedBy = "course")
	private Set<Batch> batches;
	

	public Course() {
		super();
	}

	public Course(String courseName, String courseSyllabus, String duration) {
		super();
		this.courseName = courseName;
		this.courseSyllabus = courseSyllabus;
		this.duration = duration;
	}

	public Course(long courseId, String courseName, String courseSyllabus, String duration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseSyllabus = courseSyllabus;
		this.duration = duration;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseSyllabus() {
		return courseSyllabus;
	}

	public void setCourseSyllabus(String courseSyllabus) {
		this.courseSyllabus = courseSyllabus;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseSyllabus=" + courseSyllabus
				+ ", duration=" + duration + "]";
	}
	
	
}
