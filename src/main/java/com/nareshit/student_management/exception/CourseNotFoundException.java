package com.nareshit.student_management.exception;

@SuppressWarnings("serial")
public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {
        super(message);
    }
}
