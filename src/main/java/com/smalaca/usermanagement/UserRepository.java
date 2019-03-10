package com.smalaca.usermanagement;

import com.smalaca.usermanagement.domain.User;

public interface UserRepository {
    void save(User user);

    boolean checkLoginExist(String login);
}
