package nl.wiggertloonstra.bible.service;

import java.util.List;

import nl.wiggertloonstra.bible.ui.view.BookView;

public interface BookService {
    
    List<BookView> getBooks();
    BookView getBookWithName(String bookName);
    BookView getBookWithId(int id);

}
