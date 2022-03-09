package com.palarczyk.socialmedia.service;

import com.palarczyk.socialmedia.domain.Post;
import com.palarczyk.socialmedia.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save (Post post){
        return postRepository.save(post);
    }

    public List<Post> all (){
        return postRepository.findAll();
    }
}
