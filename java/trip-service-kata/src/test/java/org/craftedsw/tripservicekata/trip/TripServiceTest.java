package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.StubUserSession;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TripServiceTest {

    @Test(expected = UserNotLoggedInException.class)
    public void throwsExceptionWhenUserNotLoggedIn() {

        final StubUserSession sessionWithNoUser = new StubUserSession(null);
        final TripService tripService = new TripService(sessionWithNoUser, new TripDAOImpl());
        tripService.getTripsByUser(new User());

    }

    @Test
    public void enemyUsersReturnsNoTrips(){
        final User loggedInUser = new User();
        final User enemyUser = new User();

        final TripService tripService = new TripService(new StubUserSession(loggedInUser), new TripDAOImpl());

        assertTrue(tripService.getTripsByUser(enemyUser).isEmpty());
    }

    @Test
    public void friendUserWithNoTrips() {
        final User loggedInUser = new User();
        final User friendUser = new User();

        friendUser.addFriend(loggedInUser);

        MockTripDAO mockTripDAO = new MockTripDAO();

        final TripService tripService = new TripService(new StubUserSession(loggedInUser), mockTripDAO);

        assertTrue(tripService.getTripsByUser(friendUser).isEmpty());
        assertEquals(friendUser, mockTripDAO.calledWithUser());
    }

//    @Test
//    public void friendUserWithTrips() {
//        final User loggedInUser = new User();
//        final User friendUser = new User();
//        final Trip friendTrip = new Trip();
//        friendUser.addTrip(friendTrip);
//
//        friendUser.addFriend(loggedInUser);
//
//        final TripService tripService = new TripService(new StubUserSession(loggedInUser));
//
//        assertEquals(1, tripService.getTripsByUser(friendUser).size());
//        assertEquals(friendTrip, tripService.getTripsByUser(friendUser).get(0));
//    }

}
