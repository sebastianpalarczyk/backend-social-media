package com.palarczyk.socialmedia.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    @Column(name = "file_id")
    private Long fileId;
    @Column(name = "date_of_recording")
    private LocalDateTime dateOfRecording;
    @OneToOne(mappedBy = "file", fetch = FetchType.LAZY)
    private Post post;


    @PrePersist
    public void prePersist() {
        dateOfRecording = LocalDateTime.now();
    }


    public File() {
    }

    public File(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public File(Long id, String fileName, String fileType, Long fileId, LocalDateTime dateOfRecording, Post post) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileId = fileId;
        this.dateOfRecording = dateOfRecording;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public LocalDateTime getDateOfRecording() {
        return dateOfRecording;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
