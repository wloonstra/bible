package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BookDo;

/**
 * BookRepository to get books.
 * @author wloonstra
 */
public interface BookRepository {

    /**
     * @return all books
     */
    List<BookDo> getBooks();
    
    /**
     * Return the book for a given name.
     * @param bookName to return the book for
     * @return book with given name
     */
    BookDo getBookWithName(String bookName);

}