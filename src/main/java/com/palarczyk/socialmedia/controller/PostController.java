package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.assembler.PostDtoAssembler;
import com.palarczyk.socialmedia.service.PostService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final PostService postService;
    private final PostDtoAssembler postDtoAssembler;

    public PostController(PostService postService, PostDtoAssembler postDtoAssembler) {
        this.postService = postService;
        this.postDtoAssembler = postDtoAssembler;
    }
}
