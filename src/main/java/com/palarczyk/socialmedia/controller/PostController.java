package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.DTO.PostDto;
import com.palarczyk.socialmedia.assembler.PostDtoAssembler;
import com.palarczyk.socialmedia.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PostController {

    private final PostService postService;
    private final PostDtoAssembler postDtoAssembler;

    public PostController(PostService postService, PostDtoAssembler postDtoAssembler) {
        this.postService = postService;
        this.postDtoAssembler = postDtoAssembler;
    }

    @GetMapping(value = "/posts")
    public List<PostDto> all(){
        return postService.all().stream()
                .map(postDtoAssembler::toDto)
                .collect(Collectors.toList());
    }
}
