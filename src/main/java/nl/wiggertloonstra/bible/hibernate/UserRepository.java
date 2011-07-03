package nl.wiggertloonstra.bible.hibernate;

import nl.wiggertloonstra.bible.domain.User;

/**
 * UserRepository to store and retrieve users.
 * @author wloonstra
 */
public interface UserRepository {

    User store(User newUser);
    User getUserWithId(int userId);

}