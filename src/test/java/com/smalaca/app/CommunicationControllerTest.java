package com.smalaca.app;

import org.junit.Test;

public class CommunicationControllerTest {
    @Test
    public void shouldSendEmail() {
        String userId = "123";
        String emailAddress = "sebastian.malaca@gmail.com";
        String message = "Can you lend 50 PLN?";
        givenUserWithEmail(userId, emailAddress);

        new CommunicationController().send(userId, message);

        thenEmailWasSent(emailAddress, message);
    }

    private void givenUserWithEmail(String userId, String emailAddress) {

    }

    private void thenEmailWasSent(String emailAddress, String message) {

    }
}
