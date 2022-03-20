package com.palarczyk.socialmedia.repository;

import com.palarczyk.socialmedia.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface FileRepository extends JpaRepository<File, Long> {

    File findFileById(Long id);
    File findFileByFileNameAndDateOfRecording(String name, LocalDateTime date);
}
