package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.DTO.UserDto;
import com.palarczyk.socialmedia.assembler.UserDtoAssembler;
import com.palarczyk.socialmedia.domain.User;
import com.palarczyk.socialmedia.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public UserDto create(@RequestBody UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        return userDtoAssembler.toDto(userService.save(user));
    }

    @CrossOrigin
    @GetMapping(value = "/users")
    public List<UserDto> all() {
        return userService.all().stream()
                .map(userDtoAssembler::toDto)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping(value = "/user/{id}")
    public UserDto findOne(@PathVariable Long id) {
        return userDtoAssembler.toDto(userService.findById(id).get());
    }

    @CrossOrigin
    @PutMapping(value = "/user/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto) {
      User user = userService.findById(id).get();
      user.setEmail(userDto.getEmail());
      user.setFirstName(userDto.getFirstName());
      user.setLastName(userDto.getLastName());
      user.setPassword(userDto.getPassword());
      return userDtoAssembler.toDto(userService.save(user));
    }

    @CrossOrigin
    @DeleteMapping(value = "/user/{id}")
    public UserDto delete(@PathVariable Long id) {
        User user = userService.findById(id).get();
        userService.delete(user);
        return userDtoAssembler.toDto(user);
    }
}
