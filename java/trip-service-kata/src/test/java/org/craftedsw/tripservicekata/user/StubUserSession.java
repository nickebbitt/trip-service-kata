package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class StubUserSession implements UserSession {

    private final User stubbedUser;

    public StubUserSession(User stubbedUser) {
        this.stubbedUser = stubbedUser;
    }

    public User getLoggedUser() {
        return stubbedUser;
    }
}
