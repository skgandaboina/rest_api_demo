package com.sai.demo.service;

public interface UserService {
    public String Login(String username, String password);
    public String Register(String username, String firstname,String lastname,String email, String password);
}
