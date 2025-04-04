package com.example.smishingdetectionapp.ui.Forgotpassword.model;

import com.google.gson.annotations.SerializedName;

public class VerifyRequest {
    @SerializedName("email")
    private String email;

    @SerializedName("otp")
    private String otp;

    @SerializedName("flowType")
    private String flowType; // "forgot_password" or "registration"

    public VerifyRequest(String email, String otp, String flowType) {
        this.email = email;
        this.otp = otp;
        this.flowType = flowType;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getOtp() {
        return otp;
    }

    public String getFlowType() {
        return flowType;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    @Override
    public String toString() {
        return "VerifyRequest{" +
                "email='" + email + '\'' +
                ", otp='" + otp + '\'' +
                ", flowType='" + flowType + '\'' +
                '}';
    }
}