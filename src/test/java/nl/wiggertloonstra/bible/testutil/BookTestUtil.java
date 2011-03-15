package nl.wiggertloonstra.bible.testutil;

import nl.wiggertloonstra.bible.domain.Book;

public class BookTestUtil {
    
    public static Book aBookWithName(String name) {
        Book book = new Book();
        book.setName(name);
        return book;
    }

}
