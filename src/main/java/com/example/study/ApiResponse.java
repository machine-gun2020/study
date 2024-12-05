package com.example.study;

import com.example.study.dto.ColsDto;

public class ApiResponse {
    private boolean success;
    private String message;
    private ColsDto data;

    // Constructor, getters, and setters
    public ApiResponse(boolean success, String message, ColsDto data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ColsDto getData() {
        return data;
    }

    public void setData(ColsDto data) {
        this.data = data;
    }
// Getters and setters...
}
