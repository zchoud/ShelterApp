package com.app.dashboard.models;

import org.bson.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddUserRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String access;

    private String password;

    public AddUserRequest(String firstName, String lastName, String email, String access, String password){
        User instance = new User();
        if (firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("Must specify a first name.");
        }
        if (lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("Must specify a last name.");
        }
        if (email == null || email.isEmpty() || !instance.isValidEmail(email)){
            throw new IllegalArgumentException("Invalid email.");
        }
        if (access == null || access.isEmpty()){
            access = UserRole.VIEW.toString().toLowerCase();
        } else if (!UserRole.isValidRole(access)) {
            throw new IllegalArgumentException("Invalid role name, must be view, manager or admin.");
        }
        if (password.isEmpty() || password.length() < 8){
            throw new IllegalArgumentException("Password must be greater than 8 characters.");
        }
        String hashedPassword = instance.hashPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.access = access;
        this.password = hashedPassword;
        this.email = email;
    }

    public Document toDocument() {
        return new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("password", password)
                .append("access", access);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
