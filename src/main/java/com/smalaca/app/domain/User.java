package com.smalaca.app.domain;

public class User {
    private String emailAddress;

    public User(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
