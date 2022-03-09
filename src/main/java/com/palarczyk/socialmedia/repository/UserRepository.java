package com.palarczyk.socialmedia.repository;

import com.palarczyk.socialmedia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
