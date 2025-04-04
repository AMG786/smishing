package com.example.smishingdetectionapp.ui.Forgotpassword.model;

import com.google.gson.annotations.SerializedName;

public class VerificationResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("token")
    private String token; // For JWT authentication

    @SerializedName("expiresIn")
    private long expiresIn; // Token expiry in seconds

    public VerificationResponse(boolean success, String message, String token, long expiresIn) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.expiresIn = expiresIn;
    }

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    // Setters
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "VerificationResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", token='" + (token != null ? "***" : "null") + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}