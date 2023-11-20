package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.service.FileService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
}
