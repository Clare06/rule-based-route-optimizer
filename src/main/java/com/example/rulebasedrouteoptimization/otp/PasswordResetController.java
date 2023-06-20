package com.example.rulebasedrouteoptimization.otp;

import com.example.rulebasedrouteoptimization.model.ForgotPasswordRequest;
import com.example.rulebasedrouteoptimization.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RequestMapping("/forgotpass")
@RestController
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class PasswordResetController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private OtpTableService otpTableService;
//    private String otp;
//    private boolean verified = false;
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ForgotPasswordRequest request) {
        // Find the user by email
        User user = userService.findUserByEmail(request.getEmail());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        if (otpTableService.isPresent(request.getEmail())){

            otpTableService.deleteByUid(user.getId());
        }
        String otp=generateOTP();
        otpTableService.setOtp(request,otp);

        emailService.sendPasswordResetEmail(user.getEmail(), otp);

        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody Otp otp){
            User usr=userService.findUserByEmail(otp.getEmail());

        if (otpTableService.verifyOtp(usr.getId(),otp.getOtp())){

           return new ResponseEntity(HttpStatus.OK);
        }
        return new  ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/new-pass")
    public ResponseEntity<String> setNewPass(@RequestBody NewPass newPass){
            User usr=userService.findUserByEmail(newPass.getEmail());
        if (newPass.getNewPass().equals(newPass.getConfPass()) && otpTableService.verifyOtp(usr.getId(),newPass.getOtp())){
          User user = userService.findUserByEmail(newPass.getEmail());
          userService.updatePassword(user,newPass.getNewPass());
          otpTableService.delete(usr.getId(),newPass.getOtp());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new  ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    private String generateOTP() {
        UUID uuid = UUID.randomUUID();
        String otp = uuid.toString().replace("-", "").substring(0, 6);
        return otp;
    }
}

