package com.codeup.facebookclone.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

//    @Column(name = "reset_password_token")
//    private String resetPasswordToken;

    @Column(nullable = false)
    private boolean isAdmin;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = true, columnDefinition = "varchar(255) default 'https://i.pinimg.com/originals/c3/e1/0a/c3e10aeb8ecc1f529d592146eb599ddf.jpg'")
    private String profileImg;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Friend> friends;

    private boolean isEnabled;

    public User() {
    }

    public User(long id, String firstName, String lastName, String email, String username, String password, boolean isAdmin, Date birthday, String profileImg, boolean isEnabled) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
//        this.resetPasswordToken = resetPasswordToken;
        this.isAdmin = isAdmin;
        this.birthday = birthday;
        this.profileImg = profileImg;
        this.isEnabled = isEnabled;
    }

    public User(String firstName, String lastName, String email, String username, String password, boolean isAdmin, Date birthday, String profileImg, boolean isEnabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
//        this.resetPasswordToken = resetPasswordToken;
        this.isAdmin = isAdmin;
        this.birthday = birthday;
        this.profileImg = profileImg;
        this.isEnabled = isEnabled;
    }

    public User(User copy) {
        id = copy.id;
        firstName = copy.firstName;
        lastName = copy.lastName;
        email = copy.email;
        username = copy.username;
        password = copy.password;
//        resetPasswordToken = copy.resetPasswordToken;
        isAdmin = copy.isAdmin;
        birthday = copy.birthday;
        profileImg = copy.profileImg;
        isEnabled = copy.isEnabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getResetPasswordToken() {
//        return resetPasswordToken;
//    }
//
//    public void setResetPasswordToken(String resetPasswordToken) {
//        this.resetPasswordToken = resetPasswordToken;
//    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="users_groups",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="group_id")}
    )
    private List<Group> groups;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="users_events",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="event_id")}
    )
    private List<Event> events;


}
