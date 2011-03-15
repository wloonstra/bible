package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.domain.Book;

/**
 * BookRepository to get books.
 * @author wloonstra
 */
public interface BookRepository {

    /**
     * @return all books
     */
    List<Book> getBooks();
    
    /**
     * Return the book for a given name.
     * @param bookName to return the book for
     * @return book with given name
     */
    Book getBookWithName(String bookName);

}