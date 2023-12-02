package com.app.dashboard.controllers;

import com.app.dashboard.UserRepository;
import com.app.dashboard.models.*;
import com.app.dashboard.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class UserController {
    private <T> T defaultIfNull(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    @Autowired
    UserService service;

    @Autowired
    UserRepository repository;

    @GetMapping("/user")
    @ApiOperation(value = "Get User by email", notes = "Get user details by email.")
    public User getUserByEmail(@RequestParam String email) {
        User user = service.findByEmail(email);
        if(user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "Get User by ID", notes = "Get user details by ID.")
    public User getUserById(@PathVariable String id) {
        User user = service.findById(id);
        if(user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }

    @PostMapping("/user")
    @ApiOperation(value = "Add User", notes = "Get user details by ID.")
    public User addUser(
            @RequestBody(required = true) AddUserRequest request,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request: "+bindingResult.toString());
        }
        User user = service.findByEmail(request.getEmail());
        if (user != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User exists.");
        }
        User new_user = service.addUser(request);
        return new_user;
    }

    @PostMapping("/user/login")
    @ApiOperation(value = "Login with user credentials", notes = "Validate user credentials returning user.")
    public User login(
            @RequestBody(required = true) LoginRequest request,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request: "+bindingResult.toString());
        }
        User user = service.findByEmail(request.getEmail());
        if (user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }
        if (!user.matchingPassword(request.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password does not match.");
        }
        return user;
    }
}
