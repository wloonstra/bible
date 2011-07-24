package nl.wiggertloonstra.bible.testutil;

import nl.wiggertloonstra.bible.hibernate.domain.BookDo;

public class BookTestUtil {
    
    public static BookDo aBookWithId(int id) {
        BookDo book = new BookDo();
        book.setId(id);
        return book;
    }

}
