package com.codeup.facebookclone.models;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = true)
    private Boolean sendEmail;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToOne
    private User owner;

    public Comment() {
    }

    public Comment(long id, String comment, Boolean sendEmail, Post post) {
        this.id = id;
        this.comment = comment;
        this.sendEmail = sendEmail;
        this.post = post;
    }

    public Comment(String comment, Boolean sendEmail, Post post) {
        this.comment = comment;
        this.sendEmail = sendEmail;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
