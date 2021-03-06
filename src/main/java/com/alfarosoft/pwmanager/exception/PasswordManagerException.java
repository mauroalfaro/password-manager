package com.alfarosoft.pwmanager.exception;

public class PasswordManagerException extends RuntimeException{
    private String message;
    private Integer status;

    public PasswordManagerException(String message, Integer status) {
        super();
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
