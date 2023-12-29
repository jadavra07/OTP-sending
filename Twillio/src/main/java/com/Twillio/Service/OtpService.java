package com.Twillio.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;


    public void sendOtp(String tophoneNumber, String otp) {
        Twilio.init(accountSid, authToken);

        // Send SMS using Twilio
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(tophoneNumber),
                        new com.twilio.type.PhoneNumber("+14152337308"),
                        "Your OTP is: " + otp).create();

        System.out.println("OTP sent: " + message.getSid());
    }
}