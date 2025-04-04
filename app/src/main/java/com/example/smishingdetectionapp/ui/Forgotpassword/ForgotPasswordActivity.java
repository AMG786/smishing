package com.example.smishingdetectionapp.ui.Forgotpassword;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.view.View;
//
//import android.widget.Toast;
//
//import androidx.lifecycle.ViewModelProvider;
import com.example.smishingdetectionapp.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ActivityForgotPasswordBinding binding;
//    private ForgotPasswordViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        viewModel = new ViewModelProvider(this).get(ForgotPasswordViewModel.class);
//
//        setupObservers();
//        setupListeners();
    }

//    private void setupObservers() {
//        viewModel.getIsLoading().observe(this, isLoading -> {
//            binding.progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
//            binding.sendOtpButton.setEnabled(!isLoading);
//        });
//
////        viewModel.getResetResponse().observe(this, response -> {
////            if ((response != null) && response.isSuccess()) {
////                navigateToOtpVerification(binding.emailInput.getText().toString());
////            }
////        });
//
//        viewModel.getError().observe(this, error -> {
//            if (error != null) {
//                Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void setupListeners() {
//        binding.sendOtpButton.setOnClickListener(v -> {
//            String email = binding.emailInput.getText().toString().trim();
//            if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                viewModel.requestPasswordReset(email);
//            } else {
//                binding.emailInput.setError("Please enter a valid email");
//            }
//        });
//
//        binding.backButton.setOnClickListener(v -> finish());
//    }

    private void navigateToOtpVerification(String email) {
        Intent intent = new Intent(this, OtpVerificationActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("flow", "forgot_password");
        startActivity(intent);
    }
}