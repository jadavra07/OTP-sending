package com.Twillio.Controller;


import com.Twillio.Service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class OtpController {

    @Autowired
  private OtpService otpService;

    @PostMapping("/send/otp")
    public String sendOtp(@RequestParam String phoneNumber) {
        String otp = generateOtp();
        otpService.sendOtp(phoneNumber, otp);
        return "opt is send";
    }

    public String generateOtp() {
        // Generate a 6-digit OTP
        Random random = new Random();
        int otp = 100_000 + random.nextInt(900_000);
        return String.valueOf(otp);
    }
    public void test(){
   
    }
}

