package com.example.smishingdetectionapp.ui.Forgotpassword.model;

import com.google.gson.annotations.SerializedName;

public class OtpResendResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("retryAfter")
    private int retryAfter; // In seconds

    public OtpResendResponse(boolean success, String message, int retryAfter) {
        this.success = success;
        this.message = message;
        this.retryAfter = retryAfter;
    }

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getRetryAfter() {
        return retryAfter;
    }
}