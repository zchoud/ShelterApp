package com.app.dashboard.models;

import org.bson.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginRequest {
    private String firstName;

    private String lastName;

    private String email;

    private String access;

    private String password;

    public LoginRequest(String firstName, String lastName, String email, String access, String password){
        User instance = new User();
        if (email == null || email.isEmpty() || !instance.isValidEmail(email)){
            throw new IllegalArgumentException("Invalid email.");
        }
        if (password == null || password.isEmpty()){
            throw new IllegalArgumentException("Password must be entered.");
        }
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
