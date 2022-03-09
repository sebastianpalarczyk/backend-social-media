package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.DTO.PostDto;
import com.palarczyk.socialmedia.assembler.PostDtoAssembler;
import com.palarczyk.socialmedia.domain.Post;
import com.palarczyk.socialmedia.service.PostService;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @PostMapping(value = "/post")
    public PostDto create(@RequestBody PostDto postDto){
        Post post = new Post();
        post.setMessage(postDto.getMessage());
        post.setComment(postDto.getComment());
        return postDtoAssembler.toDto(postService.save(post));
    }

    @CrossOrigin
    @GetMapping(value = "/posts")
    public List<PostDto> all(){
        return postService.all().stream()
                .map(postDtoAssembler::toDto)
                .collect(Collectors.toList());
    }
}
