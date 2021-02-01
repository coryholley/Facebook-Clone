package com.codeup.facebookclone.models;

import javax.persistence.*;

@Entity
@Table(name = "status_updates")
public class Status_Update {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String update;

    @Column(nullable = false)
    private String update_image;

    public Status_Update() {
    }

    public Status_Update(long id, String update, String update_image) {
        this.id = id;
        this.update = update;
        this.update_image = update_image;
    }

    public Status_Update(String update, String update_image) {
        this.update = update;
        this.update_image = update_image;
    }

    public Status_Update(Status_Update copy) {
        id = copy.id;
        update = copy.update;
        update_image = copy.update_image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getUpdate_image() {
        return update_image;
    }

    public void setUpdate_image(String update_image) {
        this.update_image = update_image;
    }
}
