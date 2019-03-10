package com.smalaca.app;

import com.smalaca.app.domain.User;

public interface UserRepository {
    User getBy(String userId);
}
