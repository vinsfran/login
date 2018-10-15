package com.example.login.model;

public class IsLoggedIn {
    private boolean status;

    public IsLoggedIn() {
    }

    public IsLoggedIn(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IsLoggedIn{" +
                "status=" + status +
                '}';
    }
}
