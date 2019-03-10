package com.smalaca.usermanagement.domain;

import java.util.Objects;

public class User {
    private final String login;
    private final String password;
    private final String emailAddress;

    public User(String login, String password, String emailAddress) {
        this.login = login;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(emailAddress, user.emailAddress);
    }

    public boolean hasLoginSameAs(String login) {
        return this.login.equals(login);
    }
}
