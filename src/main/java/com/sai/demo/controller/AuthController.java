package com.sai.demo.controller;

import com.sai.demo.model.User;
import com.sai.demo.repository.UserRepository;
import com.sai.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UserService userService;

    /*public AuthController(UserService userService) {
        this.userService = userService;
    }*/

    @PostMapping("/doRegister")
    @ResponseBody
    public String handleRegister(
            @RequestParam String username,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String password) {

        return userService.Register(username,firstname,lastname,email,password);
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password) {

        return userService.Login(username, password);
    }
}
