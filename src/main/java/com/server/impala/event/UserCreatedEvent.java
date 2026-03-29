package com.server.impala.event;

import com.server.impala.entity.User;

public class UserCreatedEvent {

    private final User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}