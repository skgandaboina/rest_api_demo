package com.sai.demo.service.impl;

import com.sai.demo.model.User;
import com.sai.demo.repository.UserRepository;
import com.sai.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
/*
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
*/

    @Override
    public String Login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return "Invalid credentials!";
        }

        return "Login successful! Welcome, " + user.getUserName();
    }

    @Override
    public String Register(String username, String firstname,String lastname,String email,
                           String password) {
        if (userRepository.existsByUsername(username)) {
            return "Username already exists. Try another.";
        } else if(userRepository.existsByEmail(email)) {
            return "Email already exists. Try another.";
        }

        User user = new User();
        user.setUserName(username);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password); // Note: No hashing yet, just for demo

        userRepository.save(user);
        return "Registration successful!";
    }
}
