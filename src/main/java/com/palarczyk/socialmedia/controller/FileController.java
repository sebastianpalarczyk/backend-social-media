package com.palarczyk.socialmedia.controller;

import com.palarczyk.socialmedia.service.FileService;
import org.springframework.stereotype.Controller;

@Controller
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
}
