package com.codeup.facebookclone.models;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private Boolean sentRequest;

    @Column(nullable = true)
    private Boolean requestAccepted;

    @Column(nullable = true)
    private Boolean sendEmail;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Friend() {
    }

    public Friend(long id, Boolean sentRequest, Boolean requestAccepted, Boolean sendEmail) {
        this.id = id;
        this.sentRequest = sentRequest;
        this.requestAccepted = requestAccepted;
        this.sendEmail = sendEmail;
    }

    public Friend(Boolean sentRequest, Boolean requestAccepted, Boolean sendEmail) {
        this.sentRequest = sentRequest;
        this.requestAccepted = requestAccepted;
        this.sendEmail = sendEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getSentRequest() {
        return sentRequest;
    }

    public void setSent_Request(Boolean sentRequest) {
        this.sentRequest = sentRequest;
    }

    public Boolean getRequestAccepted() {
        return requestAccepted;
    }

    public void setRequestAccepted(Boolean requestAccepted) {
        this.requestAccepted = requestAccepted;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
