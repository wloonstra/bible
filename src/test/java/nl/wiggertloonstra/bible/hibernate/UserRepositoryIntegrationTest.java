package nl.wiggertloonstra.bible.hibernate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.domain.User;

import org.junit.Test;

public class UserRepositoryIntegrationTest {
    
    @Test
    public void storeAndRetrieveUser() throws Exception {
        User newUser = new User();
        newUser.setUsername("nieuwe user");
        
        UserRepository userRepository = new UserRepository();
        User storedUser = userRepository.store(newUser);
        
        User retrievedUser = userRepository.getUserWithId(storedUser.getId());
        assertThat(retrievedUser.getUsername(), is("nieuwe user"));
        
    }

}
