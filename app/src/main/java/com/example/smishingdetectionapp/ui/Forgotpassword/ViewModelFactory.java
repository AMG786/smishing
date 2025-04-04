package com.example.smishingdetectionapp.ui.Forgotpassword;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if (modelClass.isAssignableFrom(ForgotPasswordViewModel.class)) {
//            return (T) new ForgotPasswordViewModel();
//        } else if (modelClass.isAssignableFrom(OtpVerificationViewModel.class)) {
//            return (T) new OtpVerificationViewModel();
//        } else if (modelClass.isAssignableFrom(ResetPasswordViewModel.class)) {
//            return (T) new ResetPasswordViewModel();
//        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
