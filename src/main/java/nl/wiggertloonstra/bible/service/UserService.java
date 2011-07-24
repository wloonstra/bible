package nl.wiggertloonstra.bible.service;

import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

public interface UserService {
    
    UserDo getUserWithId(int userId);
    UserDo userExistingOrNewWithEmail(String email);

}
