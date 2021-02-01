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
    private String first_name;

    @Column(nullable = false, length = 100)
    private String last_name;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @Column(nullable = false)
    private boolean isAdmin;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = true, columnDefinition = "varchar(255) default 'https://i.pinimg.com/originals/c3/e1/0a/c3e10aeb8ecc1f529d592146eb599ddf.jpg'")
    private String profile_img;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Friend> friends;

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public List<Status_Update> getStatus_updates() {
        return status_updates;
    }

    public void setStatus_updates(List<Status_Update> status_updates) {
        this.status_updates = status_updates;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Status_Update> status_updates;

    private boolean isEnabled;

    public User() {
    }

    public User(long id, String first_name, String last_name, String email, String username, String password, String resetPasswordToken, boolean isAdmin, Date birthday, String profile_img, boolean isEnabled) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.resetPasswordToken = resetPasswordToken;
        this.isAdmin = isAdmin;
        this.birthday = birthday;
        this.profile_img = profile_img;
        this.isEnabled = isEnabled;
    }

    public User(String first_name, String last_name, String email, String username, String password, String resetPasswordToken, boolean isAdmin, Date birthday, String profile_img, boolean isEnabled) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.resetPasswordToken = resetPasswordToken;
        this.isAdmin = isAdmin;
        this.birthday = birthday;
        this.profile_img = profile_img;
        this.isEnabled = isEnabled;
    }

    public User(User copy) {
        id = copy.id;
        first_name = copy.first_name;
        last_name = copy.last_name;
        email = copy.email;
        username = copy.username;
        password = copy.password;
        resetPasswordToken = copy.resetPasswordToken;
        isAdmin = copy.isAdmin;
        birthday = copy.birthday;
        profile_img = copy.profile_img;
        isEnabled = copy.isEnabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

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

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
