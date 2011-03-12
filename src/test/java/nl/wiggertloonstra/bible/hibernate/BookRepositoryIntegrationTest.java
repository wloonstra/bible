package nl.wiggertloonstra.bible.hibernate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import nl.wiggertloonstra.bible.domain.Book;

import org.junit.Test;

public class BookRepositoryIntegrationTest {

    @Test
    public void getAllBooks() throws Exception {
        BookRepository bookRepository = new BookRepository();
        List<Book> books = bookRepository.getBooks();
        assertThat(books.size(), is(39));
    }
    
    @Test
    public void getBookByName() throws Exception {
        BookRepository bookRepository = new BookRepository();
        Book book = bookRepository.getBookWithName("Leviticus");
        assertThat(book.getName(), is("Leviticus"));
        
    }
    
}
