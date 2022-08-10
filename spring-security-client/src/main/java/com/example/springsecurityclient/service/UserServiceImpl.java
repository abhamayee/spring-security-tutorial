package com.example.springsecurityclient.service;

import com.example.springsecurityclient.entity.User;
import com.example.springsecurityclient.entity.VerificationToken;
import com.example.springsecurityclient.model.UserModel;
import com.example.springsecurityclient.repository.UserRepository;
import com.example.springsecurityclient.repository.VerificationTokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private VerificationTokeRepository verificationTokeRepository;
    @Override
    public User registerUser(UserModel userModel) {
        User user=new User();
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRoll("USER");

        repository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);

        verificationTokeRepository.save(verificationToken);
    }
}
