package com.example.smishingdetectionapp.ui.Forgotpassword;

import com.example.smishingdetectionapp.ui.Forgotpassword.model.ForgotPasswordRequest;
import com.example.smishingdetectionapp.ui.Forgotpassword.model.ForgotPasswordResponse;
import com.example.smishingdetectionapp.ui.Forgotpassword.model.ResetPasswordRequest;
import com.example.smishingdetectionapp.ui.Forgotpassword.model.ResetPasswordResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("api/auth/forgot-password")
    Call<ForgotPasswordResponse> requestPasswordReset(@Body ForgotPasswordRequest request);

    //@POST("api/auth/verify-otp")
    //Call<VerificationResponse> verifyOTP(@Body VerifyRequest request);

    @POST("api/auth/reset-password")
    Call<ResetPasswordResponse> resetPassword(@Body ResetPasswordRequest request);
}
