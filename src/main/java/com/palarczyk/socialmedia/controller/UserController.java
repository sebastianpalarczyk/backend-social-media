package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.DTO.UserDto;
import com.palarczyk.socialmedia.assembler.UserDtoAssembler;
import com.palarczyk.socialmedia.domain.User;
import com.palarczyk.socialmedia.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    private final UserDtoAssembler userDtoAssembler;

    public UserController(UserService userService, UserDtoAssembler userDtoAssembler) {
        this.userService = userService;
        this.userDtoAssembler = userDtoAssembler;
    }

    @CrossOrigin
    @PostMapping(value = "/user")
    public UserDto create(@RequestBody UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        return userDtoAssembler.toDto(userService.save(user));
    }
}
