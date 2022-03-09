package com.palarczyk.socialmedia.assembler;

import com.palarczyk.socialmedia.DTO.UserDto;
import com.palarczyk.socialmedia.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoAssembler {

    private final ModelMapper modelMapper;

    public UserDtoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User fromDto(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }
}
