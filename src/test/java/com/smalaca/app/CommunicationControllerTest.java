package com.smalaca.app;

import com.smalaca.app.communication.mail.GmailClient;
import com.smalaca.app.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class CommunicationControllerTest {
    private static final String ANY_USER_ID = "123";
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
        String anyMessage = "Can you lend 50 PLN?";
        String anyEmailAddress = "sebastian.malaca@gmail.com";
        givenUserWith(ANY_USER_ID, anyEmailAddress);

        //when
        communicationController.send(ANY_USER_ID, anyMessage);

        //then
        thenMailShouldBeSent(anyMessage, anyEmailAddress);
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowUserNotFoundException() {
        //given
        String dummyMessage = "Can you lend 50 PLN?";
        givenNotExistingUser(ANY_USER_ID);

        //when
        communicationController.send(ANY_USER_ID, dummyMessage);
    }

    private void givenNotExistingUser(String userId) {
        BDDMockito.given(userRepository.exist(userId)).willReturn(false);
    }

    private void givenUserWith(String userId, String emailAddress) {
        User user = new User(emailAddress);
        BDDMockito.given(userRepository.getBy(userId)).willReturn(user);
        BDDMockito.given(userRepository.exist(userId)).willReturn(true);
    }

    private void thenMailShouldBeSent(String message, String emailAddress) {
        BDDMockito.then(gmailClient)
                .should(Mockito.times(1))
                .send(emailAddress, message);
    }
}
