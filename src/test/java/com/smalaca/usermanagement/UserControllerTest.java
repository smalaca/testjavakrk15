package com.smalaca.usermanagement;

import com.smalaca.usermanagement.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class UserControllerTest {
    private static final String ANY_LOGIN = "login";
    private static final String ANY_PASSWORD = "password";
    private static final String ANY_EMAIL_ADDRESS = "sebastian.malaca@gmail.com";

    private UserController userController;
    private UserRepository userRepository;

    @Before
    public void initUserController() {
        userRepository = Mockito.mock(UserRepository.class);
        userController = new UserController(userRepository);
    }

    @Test
    public void shouldCreateUser() {
        //when
        userController.addUser(ANY_LOGIN, ANY_PASSWORD, ANY_EMAIL_ADDRESS);

        //then
        User user = new User(ANY_LOGIN, ANY_PASSWORD, ANY_EMAIL_ADDRESS);
        BDDMockito.then(userRepository).should().save(user);
    }

    @Test(expected = LoginExistException.class)
    public void shouldRecognizeUserWithGivenLoginExists() {
        givenSavedUserWith(ANY_LOGIN);

        //when
        userController.addUser(ANY_LOGIN, ANY_PASSWORD, ANY_EMAIL_ADDRESS);
    }

    private void givenSavedUserWith(String login) {
        BDDMockito.given(userRepository.checkLoginExist(login)).willReturn(true);
    }
}
