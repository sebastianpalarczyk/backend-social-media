package com.palarczyk.socialmedia.domain;

import javax.persistence.*;


@Entity
@Table(name= "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String comment;
    @Column(name = "file_id")
    private Long fileId;

    public Post(){

    }

    public Post(Long id, String message, String comment, Long fileId) {
        this.id = id;
        this.message = message;
        this.comment = comment;
        this.fileId = fileId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
