package nl.wiggertloonstra.bible.ui.view;

import nl.wiggertloonstra.bible.hibernate.domain.BookDo;

public class BookView {
    
    private final BookDo bookDo;

    public BookView(BookDo bookDo) {
        this.bookDo = bookDo;
    }
    
    public int getId() {
        return bookDo.getId();
    }
    
    public String getName() {
        return bookDo.getName();
    }

}
