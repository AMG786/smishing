package com.example.smishingdetectionapp.ui.Forgotpassword;

import androidx.lifecycle.MutableLiveData;

import com.example.smishingdetectionapp.ui.Forgotpassword.model.VerifyRequest;
import com.example.smishingdetectionapp.ui.Forgotpassword.model.VerificationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpVerificationRepository {
    private final ApiInterface apiService;

    public OtpVerificationRepository(ApiInterface apiService) {
        this.apiService = apiService;
    }

    public void verifyOtp(String email, String otp,
                          MutableLiveData<VerificationResponse> responseLiveData,
                          MutableLiveData<String> errorLiveData) {

//        Call<VerificationResponse> call = apiService.verifyOTP(
//                new VerifyRequest(email, otp)
//        );

//        call.enqueue(new Callback<VerificationResponse>() {
//            @Override
//            public void onResponse(Call<VerificationResponse> call,
//                                   Response<VerificationResponse> response) {
//
//                if (response.isSuccessful() && response.body() != null) {
//                    responseLiveData.postValue(response.body());
//                } else {
//                    errorLiveData.postValue("Invalid OTP. Please try again.");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<VerificationResponse> call, Throwable t) {
//                errorLiveData.postValue("Network error. Please try again.");
//            }
//        });
    }
}
