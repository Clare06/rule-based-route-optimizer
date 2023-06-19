package com.example.rulebasedrouteoptimization.otp;

import com.example.rulebasedrouteoptimization.model.User;
import com.example.rulebasedrouteoptimization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private com.example.rulebasedrouteoptimization.service.UserService usr;
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        // Update the user's password
        String encodedPassword=usr.bcryptPassword(newPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}

