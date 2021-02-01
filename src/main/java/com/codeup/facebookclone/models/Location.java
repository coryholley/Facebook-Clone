package com.codeup.facebookclone.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String street;

    @Column(nullable = false, length = 100)
    private String unit;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String state;

    @Column(nullable = false, length = 50)
    private String zip;

    @Column(nullable = false, length = 100)
    private String landmark;

    @ManyToMany(mappedBy = "userLocations")
    private List<User> users;

    @ManyToMany(mappedBy = "groupLocations")
    private List<Group> groups;

    @ManyToMany(mappedBy = "eventLocations")
    private List<Event> events;

    public Location() {
    }

    public Location(long id, String street, String unit, String city, String state, String zip, String landmark, List<User> users, List<Group> groups, List<Event> events) {
        this.id = id;
        this.street = street;
        this.unit = unit;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.landmark = landmark;
        this.users = users;
        this.groups = groups;
        this.events = events;
    }

    public Location(String street, String unit, String city, String state, String zip, String landmark, List<User> users, List<Group> groups, List<Event> events) {
        this.street = street;
        this.unit = unit;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.landmark = landmark;
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


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
