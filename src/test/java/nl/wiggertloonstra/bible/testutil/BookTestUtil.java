package nl.wiggertloonstra.bible.testutil;

import nl.wiggertloonstra.bible.hibernate.domain.BookDo;

public class BookTestUtil {
    
    public static BookDo aBookWithName(String name) {
        BookDo book = new BookDo();
        book.setName(name);
        return book;
    }

}
