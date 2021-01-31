package com.codeup.facebookclone.models;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private Boolean sent_Request;

    @Column(nullable = true)
    private Boolean request_Accepted;

    @Column(nullable = true)
    private Boolean send_Email;

    public Friend() {
    }

    public Friend(long id, Boolean sent_Request, Boolean request_Accepted, Boolean send_Email) {
        this.id = id;
        this.sent_Request = sent_Request;
        this.request_Accepted = request_Accepted;
        this.send_Email = send_Email;
    }

    public Friend(Boolean sent_Request, Boolean request_Accepted, Boolean send_Email) {
        this.sent_Request = sent_Request;
        this.request_Accepted = request_Accepted;
        this.send_Email = send_Email;
    }

    public Friend(Friend copy) {
        id = copy.id;
        sent_Request = copy.sent_Request;
        request_Accepted = copy.request_Accepted;
        send_Email = copy.send_Email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getSent_Request() {
        return sent_Request;
    }

    public void setSent_Request(Boolean sent_Request) {
        this.sent_Request = sent_Request;
    }

    public Boolean getRequest_Accepted() {
        return request_Accepted;
    }

    public void setRequest_Accepted(Boolean request_Accepted) {
        this.request_Accepted = request_Accepted;
    }

    public Boolean getSend_Email() {
        return send_Email;
    }

    public void setSend_Email(Boolean send_Email) {
        this.send_Email = send_Email;
    }
}
