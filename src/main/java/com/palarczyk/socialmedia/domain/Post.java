package com.palarczyk.socialmedia.domain;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String comment;
    @Column(name = "created_date")
    private LocalDateTime date;
    @Column(name = "username")
    private String username;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private File file;

    @PrePersist
    public void prePersist() {
        date = LocalDateTime.now();
    }

    public Post() {
    }

    public Post(Long id, String message, String comment, LocalDateTime date, Long fileId, String username, File file) {
        this.id = id;
        this.message = message;
        this.comment = comment;
        this.date = date;
        this.username = username;
        this.file = file;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
