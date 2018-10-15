package com.example.login.model;

public class Respuesta {
    private boolean success;
    private String message;

    public Respuesta() {
    }

    public Respuesta(boolean success, String message) {
        this.success = success;
        this.message = message;
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

    @Override
    public String toString() {
        return "Respuesta{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
