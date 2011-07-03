package nl.wiggertloonstra.bible.hibernate;

import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

/**
 * UserRepository to store and retrieve users.
 * @author wloonstra
 */
public interface UserRepository {

    UserDo store(UserDo newUser);
    UserDo getUserWithId(int userId);

}