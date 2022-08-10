package com.example.springsecurityclient.event.listener;

import com.example.springsecurityclient.entity.User;
import com.example.springsecurityclient.event.RegistrationCompleteEvent;
import com.example.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
   @Autowired
   private UserService service;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create the verification token for the user with link
        User user= event.getUser();
        String token = UUID.randomUUID().toString();
        service.saveVerificationTokenUser(token, user);
        //send mail to user
        String url = event.getApplicationUrl()
                + "verifyRegistration?token="
                + token;

        //sendVerificationEmail()
        log.info("click the link to verify your account: {}", url);
    }
}
