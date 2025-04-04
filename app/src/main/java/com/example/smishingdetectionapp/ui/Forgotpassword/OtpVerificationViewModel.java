package com.example.smishingdetectionapp.ui.Forgotpassword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.smishingdetectionapp.ui.Forgotpassword.model.VerificationResponse;

public class OtpVerificationViewModel extends ViewModel {
    private final OtpVerificationRepository repository;
    private final MutableLiveData<VerificationResponse> verificationResponse = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> canResendOtp = new MutableLiveData<>(false);
    private final MutableLiveData<Integer> resendCountdown = new MutableLiveData<>(60);

    public OtpVerificationViewModel(OtpVerificationRepository repository) {

        this.repository = repository;
    }

    public void verifyOtp(String email, String otp) {
        if (otp == null || otp.length() != 6) {
            error.setValue("Please enter a valid 6-digit OTP");
            return;
        }

        isLoading.setValue(true);
//        repository.verifyOtp(email, otp,
//                response -> {
//                    isLoading.setValue(false);
//                    verificationResponse.setValue(response);
//                },
//                errorMessage -> {
//                    isLoading.setValue(false);
//                    error.setValue(errorMessage);
//                }
//        );
    }

    public void startResendCountdown() {
        // Implement countdown logic here
        // Update resendCountdown and canResendOtp values
    }

    public LiveData<VerificationResponse> getVerificationResponse() {
        return verificationResponse;
    }

    public LiveData<String> getError() {
        return error;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<Boolean> getCanResendOtp() {
        return canResendOtp;
    }

    public LiveData<Integer> getResendCountdown() {
        return resendCountdown;
    }

    public void requestNewOtp(String email) {
    }
}