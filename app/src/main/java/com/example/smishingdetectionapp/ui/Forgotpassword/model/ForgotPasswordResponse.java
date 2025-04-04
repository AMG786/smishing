package com.example.smishingdetectionapp.ui.Forgotpassword.model;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("otpSent")
    private boolean otpSent;

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

    public boolean isOtpSent() {
        return otpSent;
    }

    public void setOtpSent(boolean otpSent) {
        this.otpSent = otpSent;
    }

    @Override
    public String toString() {
        return "ForgotPasswordResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", otpSent=" + otpSent +
                '}';
    }
}
