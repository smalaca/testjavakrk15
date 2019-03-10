package com.smalaca.app;

import com.smalaca.app.communication.mail.GmailClient;
import com.smalaca.app.domain.User;

public class CommunicationController {
    private final UserRepository userRepository;
    private final GmailClient gmailClient;

    public CommunicationController(UserRepository userRepository, GmailClient gmailClient) {
        this.userRepository = userRepository;
        this.gmailClient = gmailClient;
    }

    public void send(String userId, String message) {
        if (userRepository.exist(userId)) {
            User user = userRepository.getBy(userId);
            String emailAddress = user.getEmailAddress();

            gmailClient.send(emailAddress, message);
        } else {
            throw new UserNotFoundException();
        }
    }
}
