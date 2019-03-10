package com.smalaca.app;

import com.smalaca.app.communication.mail.GmailClient;
import com.smalaca.app.domain.User;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class CommunicationControllerTest {
    @Test
    public void shouldSendEmail() {
        //given
        //parameters
        String userId = "123";
        String message = "Can you lend 50 PLN?";

        //object creation
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        GmailClient gmailClient = Mockito.mock(GmailClient.class);
        CommunicationController communicationController = new CommunicationController(
                userRepository, gmailClient
        );

        //givenUserWithEmail(userId, emailAddress)
        String emailAddress = "sebastian.malaca@gmail.com";
        User user = new User(emailAddress);
        BDDMockito.given(userRepository.getBy(userId)).willReturn(user);

        //when
        communicationController.send(userId, message);

        //then
        //thenEmailWasSent
        BDDMockito.then(gmailClient)
                .should(Mockito.times(1))
                .sent(emailAddress, message);
    }
}
