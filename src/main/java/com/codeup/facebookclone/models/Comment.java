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
    private Boolean send_Email;

    @ManyToOne
    @JoinColumn(name = "status_update_id")
    private Status_Update status_update;

    public Comment() {
    }

    public Comment(long id, String comment, Boolean send_Email, Status_Update status_update) {
        this.id = id;
        this.comment = comment;
        this.send_Email = send_Email;
        this.status_update = status_update;
    }

    public Comment(String comment, Boolean send_Email, Status_Update status_update) {
        this.comment = comment;
        this.send_Email = send_Email;
        this.status_update = status_update;
    }

    public Comment(Comment copy) {
        id = copy.id;
        comment = copy.comment;
        send_Email = copy.send_Email;
        status_update = copy.status_update;
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

    public Boolean getSend_Email() {
        return send_Email;
    }

    public void setSend_Email(Boolean send_Email) {
        this.send_Email = send_Email;
    }

    public Status_Update getStatus_update() {
        return status_update;
    }

    public void setStatus_update(Status_Update status_update) {
        this.status_update = status_update;
    }
}
