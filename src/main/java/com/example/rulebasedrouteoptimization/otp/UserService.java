package com.example.rulebasedrouteoptimization.otp;

import com.example.rulebasedrouteoptimization.model.User;

public interface UserService {
    User findUserByEmail(String email);

    void updatePassword(User user, String newPassword);
}

