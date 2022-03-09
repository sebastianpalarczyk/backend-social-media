package com.palarczyk.socialmedia.assembler;

import com.palarczyk.socialmedia.DTO.PostDto;
import com.palarczyk.socialmedia.domain.Post;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PostDtoAssembler {

    private final ModelMapper modelMapper;

    public PostDtoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PostDto toDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

    public Post fromDto(PostDto postDto) {
        return modelMapper.map(postDto, Post.class);
    }
}
