package com.palarczyk.socialmedia.repository;

import com.palarczyk.socialmedia.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
