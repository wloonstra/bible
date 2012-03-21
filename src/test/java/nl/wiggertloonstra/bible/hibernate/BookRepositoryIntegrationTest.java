package nl.wiggertloonstra.bible.hibernate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.Book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=true)
public class BookRepositoryIntegrationTest {

    @Autowired
    BibleRepository bibleRepository;
    
    @Test
    public void getAllBooks() throws Exception {
        List<Book> books = bibleRepository.getBooks();
        assertThat(books.size(), is(66));
    }
    
    @Test
    public void getBookByName() throws Exception {
        Book book = bibleRepository.getBookByName("Leviticus");
        assertThat(book.getName(), is("Leviticus"));
        
    }
    
}
