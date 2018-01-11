package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void userWithNoFriends() {
        assertTrue(new User().getFriends().isEmpty());
    }

    @Test
    public void userHasAFriend() {
        final User user = new User();
        final User friend = new User();
        user.addFriend(friend);

        assertEquals(1, user.getFriends().size());
    }

    @Test
    public void userHasFriends() {
        final User user = new User();
        final User friendOne = new User();
        final User friendTwo = new User();
        user.addFriend(friendOne);
        user.addFriend(friendTwo);

        assertEquals(2, user.getFriends().size());
    }

    @Test
    public void userHasNoTrips() {
      assertTrue(new User().trips().isEmpty());
    }

    @Test
    public void userHasTrip(){
        final User user = new User();
        user.addTrip(new Trip());

        assertEquals(1, user.trips().size());
    }

    @Test
    public void userHasTrips(){
        final User user = new User();
        user.addTrip(new Trip());
        user.addTrip(new Trip());

        assertEquals(2, user.trips().size());
    }
}
