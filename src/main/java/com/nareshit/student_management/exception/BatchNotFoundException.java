package com.nareshit.student_management.exception;

@SuppressWarnings("serial")
public class BatchNotFoundException extends RuntimeException {

    public BatchNotFoundException(String message) {
        super(message);
    }
}
