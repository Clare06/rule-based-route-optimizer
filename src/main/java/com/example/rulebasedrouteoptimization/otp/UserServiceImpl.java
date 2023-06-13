package com.example.rulebasedrouteoptimization.otp;

import com.example.rulebasedrouteoptimization.model.User;
import com.example.rulebasedrouteoptimization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        // Update the user's password
        user.setPassword(newPassword);
        userRepository.save(user);
    }
}

