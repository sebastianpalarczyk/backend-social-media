package com.palarczyk.socialmedia.repository;

import com.palarczyk.socialmedia.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
