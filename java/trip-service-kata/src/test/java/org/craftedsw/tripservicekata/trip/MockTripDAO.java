package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;

class MockTripDAO implements TripDAO {
    private User calledWithUser;

    public List<Trip> findTripsByUser(User user) {
        this.calledWithUser = user;
        return user.trips();
    }

    User calledWithUser() {
        return this.calledWithUser;
    }
}
