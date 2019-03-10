package com.smalaca.app;

import com.smalaca.app.communication.mail.GmailClient;
import com.smalaca.app.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class CommunicationControllerTest {
    private CommunicationController communicationController;
    private GmailClient gmailClient;
    private UserRepository userRepository;

    @Before
    public void initCommunicationController() {
        userRepository = Mockito.mock(UserRepository.class);
        gmailClient = Mockito.mock(GmailClient.class);
        communicationController = new CommunicationController(userRepository, gmailClient);
    }

    @Test
    public void shouldSendEmail() {
        //given
        String userId = "123";
        String message = "Can you lend 50 PLN?";
        String emailAddress = "sebastian.malaca@gmail.com";
        givenUserWith(userId, emailAddress);

        //when
        communicationController.send(userId, message);

        //then
        thenMailShouldBeSent(message, emailAddress);
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowUserNotFoundException() {
        //given
        String userId = "123";
        String message = "Can you lend 50 PLN?"; // message not needed
        givenNotExistingUser(userId);

        //when
        communicationController.send(userId, message);
    }

    private void givenNotExistingUser(String userId) {
        BDDMockito.given(userRepository.exist(userId)).willReturn(false);
    }

    private void givenUserWith(String userId, String emailAddress) {
        User user = new User(emailAddress);
        BDDMockito.given(userRepository.getBy(userId)).willReturn(user);
    }

    private void thenMailShouldBeSent(String message, String emailAddress) {
        BDDMockito.then(gmailClient)
                .should(Mockito.times(1))
                .send(emailAddress, message);
    }
}
