package com.palarczyk.socialmedia.repository;

import com.palarczyk.socialmedia.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
