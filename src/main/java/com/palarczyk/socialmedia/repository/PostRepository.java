package com.palarczyk.socialmedia.repository;

import com.palarczyk.socialmedia.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT DISTINCT p FROM Post p LEFT JOIN FETCH p.file")
    List<Post> findAllWithFiles();
}
