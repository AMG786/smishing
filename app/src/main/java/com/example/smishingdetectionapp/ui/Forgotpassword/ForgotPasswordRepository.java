package com.example.smishingdetectionapp.ui.Forgotpassword;

import androidx.lifecycle.MutableLiveData;

import com.example.smishingdetectionapp.ui.Forgotpassword.model.ForgotPasswordRequest;
import com.example.smishingdetectionapp.ui.Forgotpassword.model.ForgotPasswordResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForgotPasswordRepository {
    private static final String TAG = "ForgotPasswordRepo";
    private final ApiInterface apiService;

    public ForgotPasswordRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/") // Replace with your base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiInterface.class);
    }

    public void requestPasswordReset(String email,
                                     MutableLiveData<Boolean> successLiveData,
                                     MutableLiveData<String> errorLiveData) {

        Call<ForgotPasswordResponse> call = apiService.requestPasswordReset(
                new ForgotPasswordRequest(email)
        );

        call.enqueue(new Callback<ForgotPasswordResponse>() {
            @Override
            public void onResponse(Call<ForgotPasswordResponse> call,
                                   Response<ForgotPasswordResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    successLiveData.postValue(response.body().isSuccess());
                } else {
                    errorLiveData.postValue("Failed to send reset email");
                }
            }

            @Override
            public void onFailure(Call<ForgotPasswordResponse> call, Throwable t) {
                errorLiveData.postValue("Network error: " + t.getMessage());
            }
        });
    }
}
