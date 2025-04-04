package com.example.smishingdetectionapp.ui.Forgotpassword;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smishingdetectionapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.smishingdetectionapp.R;
import com.example.smishingdetectionapp.databinding.ActivityNewPasswordBinding;
import com.example.smishingdetectionapp.ui.login.LoginActivity;

public class NewPasswordActivity extends AppCompatActivity {

    private ActivityNewPasswordBinding binding;
    private ResetPasswordViewModel viewModel;
    private String email, otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        email = getIntent().getStringExtra("email");
        otp = getIntent().getStringExtra("otp");
        viewModel = new ViewModelProvider(this).get(ResetPasswordViewModel.class);

        setupObservers();
        setupListeners();
    }

    private void setupObservers() {
        viewModel.getIsLoading().observe(this, isLoading -> {
            binding.progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            binding.submitButton.setEnabled(!isLoading);
        });

        viewModel.getResetResponse().observe(this, response -> {
            if (response != null && response.isSuccess()) {
                Toast.makeText(this, "Password reset successfully!", Toast.LENGTH_SHORT).show();
                navigateToLogin();
            }
        });

        viewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.getPasswordsValid().observe(this, isValid -> {
            binding.submitButton.setEnabled(isValid);
        });
    }

    private void setupListeners() {
        binding.submitButton.setOnClickListener(v -> {
            String newPassword = binding.newPasswordInput.getText().toString().trim();
            String confirmPassword = binding.confirmPasswordInput.getText().toString().trim();
            viewModel.resetPassword(email, otp, newPassword, confirmPassword);
        });

//        binding.newPasswordInput.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable s) {
//                validatePasswords();
//            }
//            // Other required methods...
//        });
//
//        binding.confirmPasswordInput.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable s) {
//                validatePasswords();
//            }
//            // Other required methods...
//        });
//
//        binding.backButton.setOnClickListener(v -> finish());
    }

    private void validatePasswords() {
        String password = binding.newPasswordInput.getText().toString();
        String confirmPassword = binding.confirmPasswordInput.getText().toString();
        viewModel.validatePasswords(password, confirmPassword);
    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}