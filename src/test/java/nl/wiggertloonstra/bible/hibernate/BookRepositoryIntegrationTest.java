package nl.wiggertloonstra.bible.hibernate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import nl.wiggertloonstra.bible.domain.Book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
public class BookRepositoryIntegrationTest {

    @Autowired
    BookRepository bookRepository;
    
    @Test
    public void getAllBooks() throws Exception {
        List<Book> books = bookRepository.getBooks();
        assertThat(books.size(), is(39));
    }
    
    @Test
    public void getBookByName() throws Exception {
        Book book = bookRepository.getBookWithName("Leviticus");
        assertThat(book.getName(), is("Leviticus"));
        
    }
    
}
