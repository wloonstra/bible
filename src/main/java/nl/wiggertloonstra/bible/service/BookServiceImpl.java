package nl.wiggertloonstra.bible.service;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.BookRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BookDo;
import nl.wiggertloonstra.bible.ui.view.BookView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Component
public class BookServiceImpl implements BookService {

    private static final Function<BookDo, BookView> TO_BOOK_VIEW = new Function<BookDo, BookView>() {
        @Override
        public BookView apply(BookDo from) {
            return new BookView(from);
        }
    };
    private final BookRepository bookRepository;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    public List<BookView> getBooks() {
        return Lists.transform(bookRepository.getBooks(), TO_BOOK_VIEW);
    }

    @Override
    public BookView getBookWithName(String bookName) {
        return TO_BOOK_VIEW.apply(bookRepository.getBookWithName(bookName));
    }

    @Override
    public BookView getBookWithId(int id) {
        return TO_BOOK_VIEW.apply(bookRepository.getBookWithId(id));
    }
}
