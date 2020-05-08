package com.example.springcontinue.controllers;

import com.example.springcontinue.entity.ApplicationUser;
import com.example.springcontinue.service.ApplicationUserService;
import com.example.springcontinue.service.JavaUtilService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JavaUtilService jwtUtil;
    @Autowired
    private ApplicationUserService userService;

    @PostMapping
    public String login(@RequestBody ApplicationUser userCredentials) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userCredentials.getUsername(),userCredentials.getPassword())
            );
        }catch (Exception e){ throw new Exception("Invalid Credentials");}
        return jwtUtil.generateToken(userCredentials.getUsername());
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ApplicationUser user){
        userService.save(user);
        return new ResponseEntity<String>("User Created", HttpStatus.CREATED);
    }
}
