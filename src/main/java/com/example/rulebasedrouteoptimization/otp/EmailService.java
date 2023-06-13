package com.example.rulebasedrouteoptimization.otp;

public interface EmailService {
    void sendPasswordResetEmail(String to, String otp);
}

