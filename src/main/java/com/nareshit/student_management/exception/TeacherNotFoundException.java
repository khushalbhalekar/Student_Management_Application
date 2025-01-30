package com.nareshit.student_management.exception;

@SuppressWarnings("serial")
public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(String message) {
        super(message);
    }
}
