package com.smalaca.usermanagement;

import com.smalaca.usermanagement.domain.User;

public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String login, String password, String emailAddress) {
        User user = new User(login, password, emailAddress);

        userRepository.save(user);
    }
}
