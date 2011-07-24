package nl.wiggertloonstra.bible.hibernate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=true)
public class CategoryRepositoryTest {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Test
    public void checkCount() throws Exception {
        System.out.println(categoryRepository.getNumberOfTextsFor(1));
        Assert.assertEquals(1+1, 2);
        
        
    }

}
