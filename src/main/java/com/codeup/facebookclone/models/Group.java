package com.codeup.facebookclone.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = true)
    private Boolean groupRequestSent;

    @Column(nullable = true)
    private Boolean groupRequestAccepted;

    @Column(nullable = true)
    private Boolean sendEmail;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;

    public Group() {
    }

    public Group(long id, String name, String description, Boolean groupRequestSent, Boolean groupRequestAccepted, Boolean sendEmail, List<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.groupRequestSent = groupRequestSent;
        this.groupRequestAccepted = groupRequestAccepted;
        this.sendEmail = sendEmail;
        this.users = users;
    }

    public Group(String name, String description, Boolean groupRequestSent, Boolean groupRequestAccepted, Boolean sendEmail, List<User> users) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
