package com.example.smishingdetectionapp.ui.Forgotpassword.model;

import com.google.gson.annotations.SerializedName;

public class ResetPasswordResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("statusCode")
    private int statusCode;

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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ResetPasswordResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}