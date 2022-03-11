package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.domain.LoginCredentials;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "/login")
    public String login(@RequestBody LoginCredentials loginCredentials) {
        return "ok";
    }

}
