package com.smalaca.usermanagement;

import com.smalaca.usermanagement.domain.User;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class UserControllerTest {

    @Test
    public void shouldCreateUser() {
        // given
        String login = "login";
        String password = "password";
        String emailAddress = "sebastian.malaca@gmail.com";
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserController userController = new UserController(userRepository);

        //when
        userController.addUser(login, password, emailAddress);

        //then
        User user = new User(login, password, emailAddress);
        BDDMockito.then(userRepository).should().save(user);
    }
}
