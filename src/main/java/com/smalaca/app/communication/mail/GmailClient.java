package com.smalaca.app.communication.mail;

public interface GmailClient {
    void sent(String emailAddress, String message);
}
