package com.codeup.facebookclone.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = true)
    private Boolean groupRequestSent;

    @Column(nullable = true)
    private Boolean groupRequestAccepted;

    @Column(nullable = true)
    private Boolean sendEmail;

    @ManyToMany(mappedBy = "events")
    private List<User> users;

    public Event() {
    }

    public Event(long id, String title, String description, Boolean groupRequestSent, Boolean groupRequestAccepted, Boolean sendEmail, List<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.groupRequestSent = groupRequestSent;
        this.groupRequestAccepted = groupRequestAccepted;
        this.sendEmail = sendEmail;
        this.users = users;
    }

    public Event(String title, String description, Boolean groupRequestSent, Boolean groupRequestAccepted, Boolean sendEmail, List<User> users) {
        this.title = title;
        this.description = description;
        this.groupRequestSent = groupRequestSent;
        this.groupRequestAccepted = groupRequestAccepted;
        this.sendEmail = sendEmail;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getGroupRequestSent() {
        return groupRequestSent;
    }

    public void setGroupRequestSent(Boolean groupRequestSent) {
        this.groupRequestSent = groupRequestSent;
    }

    public Boolean getGroupRequestAccepted() {
        return groupRequestAccepted;
    }

    public void setGroupRequestAccepted(Boolean groupRequestAccepted) {
        this.groupRequestAccepted = groupRequestAccepted;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
