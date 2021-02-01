package com.codeup.facebookclone.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 25)
    private String name;

    @ManyToMany(mappedBy = "userLocations")
    private List<User> users;

    @ManyToMany(mappedBy = "groupLocations")
    private List<Group> groups;

    @ManyToMany(mappedBy = "eventLocations")
    private List<Event> events;

    public Location() {
    }

    public Location(long id, String name, List<User> users, List<Group> groups, List<Event> events) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.groups = groups;
        this.events = events;
    }

    public Location(String name, List<User> users, List<Group> groups, List<Event> events) {
        this.name = name;
        this.users = users;
        this.groups = groups;
        this.events = events;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
