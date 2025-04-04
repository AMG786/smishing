package com.example.smishingdetectionapp.ui.Forgotpassword;

import androidx.lifecycle.MutableLiveData;

import com.example.smishingdetectionapp.ui.Forgotpassword.model.ResetPasswordRequest;
import com.example.smishingdetectionapp.ui.Forgotpassword.model.ResetPasswordResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPasswordRepository {
    private final ApiInterface apiService;

    public ResetPasswordRepository(ApiInterface apiService) {
        this.apiService = apiService;
    }

    public void resetPassword(String email, String otp, String newPassword,
                              MutableLiveData<ResetPasswordResponse> responseLiveData,
                              MutableLiveData<String> errorLiveData) {

        Call<ResetPasswordResponse> call = apiService.resetPassword(
                new ResetPasswordRequest(email, otp, newPassword)
        );

        call.enqueue(new Callback<ResetPasswordResponse>() {
            @Override
            public void onResponse(Call<ResetPasswordResponse> call,
                                   Response<ResetPasswordResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    responseLiveData.postValue(response.body());
                } else {
                    errorLiveData.postValue("Password reset failed. Please try again.");
                }
            }

            @Override
            public void onFailure(Call<ResetPasswordResponse> call, Throwable t) {
                errorLiveData.postValue("Network error. Please check your connection.");
            }
        });
    }
}
