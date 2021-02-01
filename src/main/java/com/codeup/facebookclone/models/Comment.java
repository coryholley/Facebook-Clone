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



}
