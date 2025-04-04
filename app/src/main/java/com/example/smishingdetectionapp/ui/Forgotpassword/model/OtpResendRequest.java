package com.example.smishingdetectionapp.ui.Forgotpassword.model;

import com.google.gson.annotations.SerializedName;

public class OtpResendRequest {
    @SerializedName("email")
    private String email;

    @SerializedName("flowType")
    private String flowType;

    public OtpResendRequest(String email, String flowType) {
        this.email = email;
        this.flowType = flowType;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }
}
