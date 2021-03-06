package nl.wiggertloonstra.bible.hibernate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=true)
public class UserRepositoryIntegrationTest {
    
    @Autowired
    UserRepository userRepository;
    
    @Test
    public void storeAndRetrieveUser() throws Exception {
        UserDo newUser = new UserDo();
        newUser.setName("nieuwe user");
        
        UserDo storedUser = userRepository.store(newUser);
        
        UserDo retrievedUser = userRepository.getUserWithId(storedUser.getId());
        assertThat(retrievedUser.getName(), is("nieuwe user"));
        
    }

}
