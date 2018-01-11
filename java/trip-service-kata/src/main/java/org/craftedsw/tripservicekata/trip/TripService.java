package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    private final UserSession userSession;
    private final TripDAO tripDAO;

    public TripService(UserSession userSession, TripDAO tripDAO) {
        this.userSession = userSession;
        this.tripDAO = tripDAO;
    }

    List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> tripList = new ArrayList<>();
        User loggedUser = loggedUser();
        if (userIsFriend(user, loggedUser)) {
            tripList = tripDAO.findTripsByUser(user);
        }
        return tripList;
    }

    private User loggedUser() {
        final User loggedUser = userSession.getLoggedUser();
        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        } else {
            return loggedUser;
        }
    }

    private boolean userIsFriend(User user, User loggedUser) {
        for (User friend : user.getFriends()) {
            if (friend.equals(loggedUser)) {
                return true;
            }
        }
        return false;
    }

}
