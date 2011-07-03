package nl.wiggertloonstra.bible.hibernate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
public class UserRepositoryIntegrationTest {
    
    @Autowired
    UserRepository userRepository;
    
    @Test
    public void storeAndRetrieveUser() throws Exception {
        User newUser = new User();
        newUser.setUsername("nieuwe user");
        
        User storedUser = userRepository.store(newUser);
        
        User retrievedUser = userRepository.getUserWithId(storedUser.getId());
        assertThat(retrievedUser.getUsername(), is("nieuwe user"));
        
    }

}
