package com.smalaca.app.communication.mail;

public interface GmailClient {
    void send(String emailAddress, String message);
}
