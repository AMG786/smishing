package com.example.smishingdetectionapp.ui.Forgotpassword;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.smishingdetectionapp.ui.Forgotpassword.model.ResetPasswordResponse;

public class ResetPasswordViewModel extends ViewModel {
    private final ResetPasswordRepository repository;
    private final MutableLiveData<ResetPasswordResponse> resetResponse = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> passwordsValid = new MutableLiveData<>(false);

    public ResetPasswordViewModel() {
        this.repository = new ResetPasswordRepository(ApiClient.getClient().create(ApiInterface.class));
    }

    public void resetPassword(String email, String otp, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            error.setValue("Passwords do not match");
            return;
        }

        if (newPassword.length() < 8) {
            error.setValue("Password must be at least 8 characters");
            return;
        }

        isLoading.setValue(true);
//        repository.resetPassword(email, otp, newPassword,
//                response -> {
//                    isLoading.setValue(false);
//                    resetResponse.setValue(response);
//                },
//                errorMessage -> {
//                    isLoading.setValue(false);
//                    error.setValue(errorMessage);
//                }
//        );
    }

    public void validatePasswords(String password, String confirmPassword) {
        passwordsValid.setValue(password.equals(confirmPassword) && password.length() >= 8);
    }

    public LiveData<ResetPasswordResponse> getResetResponse() {
        return resetResponse;
    }

    public LiveData<String> getError() {
        return error;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<Boolean> getPasswordsValid() {
        return passwordsValid;
    }
}