package nl.wiggertloonstra.bible.testutil;

import nl.wiggertloonstra.bible.hibernate.domain.Book;

public class BookTestUtil {
    
    public static Book aBookWithId(int id) {
        Book book = new Book();
        book.setId(id);
        return book;
    }

}
