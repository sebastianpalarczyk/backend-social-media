package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.DTO.PostDto;
import com.palarczyk.socialmedia.assembler.PostDtoAssembler;
import com.palarczyk.socialmedia.domain.Post;
import com.palarczyk.socialmedia.service.PostService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/app")
public class PostController {

    private final PostService postService;
    private final PostDtoAssembler postDtoAssembler;

    public PostController(PostService postService, PostDtoAssembler postDtoAssembler) {
        this.postService = postService;
        this.postDtoAssembler = postDtoAssembler;
    }

    @CrossOrigin
    @PostMapping(value = "/post")
    public PostDto create(@RequestBody PostDto postDto) {
        Post post = new Post();
        post.setMessage(postDto.getMessage());
        post.setComment(postDto.getComment());
        return postDtoAssembler.toDto(postService.save(post));
    }

    @CrossOrigin
    @GetMapping(value = "/posts")
    public List<PostDto> all(@AuthenticationPrincipal UsernamePasswordAuthenticationToken userToken) {
        userToken.getAuthorities();
        return postService.all().stream()
                .map(postDtoAssembler::toDto)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping(value = "/post/{id}")
    public PostDto findOne(@PathVariable Long id) {
        return postDtoAssembler.toDto(postService.findById(id).get());
    }

    @CrossOrigin
    @PutMapping(value = "/post/{id}")
    public PostDto update(@PathVariable Long id, @RequestBody PostDto postDto) {
        Post post = postService.findById(id).get();
        post.setMessage(postDto.getMessage());
        post.setComment(postDto.getComment());
        return postDtoAssembler.toDto(postService.save(post));
    }

    @CrossOrigin
    @DeleteMapping(value = "/post/{id}")
    public PostDto delete(@PathVariable Long id) {
        Post post = postService.findById(id).get();
        postService.delete(post);
        return postDtoAssembler.toDto(post);
    }
}
