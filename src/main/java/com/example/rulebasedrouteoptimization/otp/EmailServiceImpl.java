package com.example.rulebasedrouteoptimization.otp;

import com.example.rulebasedrouteoptimization.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendPasswordResetEmail(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Password Reset");
        message.setText("Your OTP for password reset is: " + otp);

        javaMailSender.send(message);
    }
    @Override
    public void sendUserCredentialEmail( User user, String password){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Rule based route optimizer user credentials");
        message.setText("Dear "+ user.getName() + ",\n" +
                "\n" +
                "We want to emphasize the importance of protecting your user credentials. Your security is our top priority, and we are committed to ensuring the confidentiality of your account information.\n" +
                "\n" +
                "Please remember the following:\n" +
                "\n" +
                "Keep Your Credentials Confidential: Do not share your account username and password with anyone. They are unique to you and should be kept confidential.\n" +
                "\n" +
                "Change Your Password: Upon your first login, we strongly recommend changing your password. This helps ensure the security of your account. Follow the instructions provided on the login page to update your password.\n" +
                "\n" +
                "If you have any concerns or need assistance, please contact our support team. We are here to help.\n" +
                "\n" +
                "Your credentials\n" +
                "Email :"+ user.getEmail() +"\n" +
                "Password :"+ password +"\n" +
                "Thank you for your cooperation.\n" +
                "\n" +
                "Best regards,\n" +
                "\n" +
                "[Your Name]\n" +
                "[Company/Organization Name]\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n " );

        javaMailSender.send(message);
    }
}

