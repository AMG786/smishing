package com.example.smishingdetectionapp.ui.Forgotpassword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ForgotPasswordViewModel extends ViewModel {
    private final ForgotPasswordRepository repository;
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    private final MutableLiveData<String> error = new MutableLiveData<>();
    private final MutableLiveData<Boolean> resetSuccess = new MutableLiveData<>();

    public ForgotPasswordViewModel(ForgotPasswordRepository repository) {
        this.repository = repository;
    }

    public void requestPasswordReset(String email) {
        if (email == null || email.isEmpty()) {
            error.setValue("Email cannot be empty");
            return;
        }

        isLoading.setValue(true);

        // Create new MutableLiveData instances for the callbacks
        MutableLiveData<Boolean> successLiveData = new MutableLiveData<>();
        MutableLiveData<String> errorLiveData = new MutableLiveData<>();

        // Observe the temporary LiveData objects
        successLiveData.observeForever(success -> {
            resetSuccess.setValue(success);
            isLoading.setValue(false);
        });

        errorLiveData.observeForever(errorMessage -> {
            error.setValue(errorMessage);
            isLoading.setValue(false);
        });

        // Make the repository call
        repository.requestPasswordReset(email, successLiveData, errorLiveData);
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<String> getError() {
        return error;
    }

    public LiveData<Boolean> getResetSuccess() {
        return resetSuccess;
    }
}
