package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.domain.LoginCredentials;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @CrossOrigin(exposedHeaders = "Authorization")
    @PostMapping(value = "/login")
    public void login(@RequestBody LoginCredentials loginCredentials) {

    }

}
