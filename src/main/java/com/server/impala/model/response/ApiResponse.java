package com.server.impala.model.response;

import java.util.Map;

public class ApiResponse<T> {
    private T content;
    private String message;
    private Map<String, Object>errors;

    public ApiResponse(T content, String message, Map<String, Object> errors) {
        this.content = content;
        this.message = message;
        this.errors = errors;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, Object> errors) {
        this.errors = errors;
    }
}