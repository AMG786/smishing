package com.example.smishingdetectionapp.ui.Forgotpassword;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smishingdetectionapp.R;


import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.example.smishingdetectionapp.databinding.ActivityOtpVerificationBinding;

public class OtpVerificationActivity extends AppCompatActivity {

    private ActivityOtpVerificationBinding binding;
    private OtpVerificationViewModel viewModel;
    private String email;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpVerificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        email = getIntent().getStringExtra("email");
        viewModel = new ViewModelProvider(this).get(OtpVerificationViewModel.class);

        setupUI();
        setupObservers();
        setupListeners();
        startOtpCountdown();
    }

    private void setupUI() {
        binding.otpSubtitle.setText(getString(R.string.otp_sent_to, email));
    }

    private void setupObservers() {
        viewModel.getIsLoading().observe(this, isLoading -> {
            binding.progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            binding.verifyButton.setEnabled(!isLoading);
        });

        viewModel.getVerificationResponse().observe(this, response -> {
            if (response != null && response.isSuccess()) {
                navigateToNewPassword(email, binding.otpInput.getText().toString());
            }
        });

        viewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.getCanResendOtp().observe(this, canResend -> {
            binding.resendOtpText.setEnabled(canResend);
        });

        viewModel.getResendCountdown().observe(this, seconds -> {
            binding.resendOtpText.setText(seconds > 0 ?
                    getString(R.string.resend_otp_in, seconds) :
                    getString(R.string.resend_otp));
        });
    }

    private void setupListeners() {
        binding.verifyButton.setOnClickListener(v -> {
            String otp = binding.otpInput.getText().toString().trim();
            if (otp.length() == 6) {
                viewModel.verifyOtp(email, otp);
            } else {
                binding.otpInput.setError("Enter 6-digit OTP");
            }
        });

        binding.resendOtpText.setOnClickListener(v -> {
            viewModel.requestNewOtp(email);
            startOtpCountdown();
        });

       // binding.backButton.setOnClickListener(v -> finish());
    }

    private void startOtpCountdown() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
//                viewModel.getResendCountdown().setValue((int) (millisUntilFinished / 1000));
            }

            public void onFinish() {
//                viewModel.getCanResendOtp().setValue(true);
            }
        }.start();
    }

    private void navigateToNewPassword(String email, String otp) {
        Intent intent = new Intent(this, NewPasswordActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("otp", otp);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}