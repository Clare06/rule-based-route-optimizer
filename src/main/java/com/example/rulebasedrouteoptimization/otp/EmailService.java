package com.example.rulebasedrouteoptimization.otp;

import com.example.rulebasedrouteoptimization.model.User;

public interface EmailService {
    void sendPasswordResetEmail(String to, String otp);
    void sendUserCredentialEmail( User user,String password);
}

