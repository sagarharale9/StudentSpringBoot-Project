package com.training.entity;

public class ApiResponse {
    private String status;
    private String message;
    private Object student;


    // constructors, getters, and setters

    public ApiResponse(String status, String message, Object student) {
        this.status = status;
        this.message = message;
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getStudent() {
        return student;
    }

    public void setStudent(Object student) {
        this.student = student;
    }
}
