package nl.wiggertloonstra.bible.hibernate;

import static org.hibernate.criterion.Restrictions.like;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BookDo;

import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Hibernate implementation of BookRepository.
 * @author wloonstra
 */
@Component
public class HibernateBookRepository implements BookRepository {
    
    private final SessionManager sessionManager;

    @Autowired
    public HibernateBookRepository(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    
    @Override
    public List<BookDo> getBooks() {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<BookDo> books = (List<BookDo>) session.createCriteria(BookDo.class).list();
        return books;
    }

    @Override
    public BookDo getBookWithName(String bookName) {
        Session session = sessionManager.session();
        return (BookDo) session
                .createCriteria(BookDo.class)
                .add(like("name", bookName))
                .uniqueResult();
    }

    @Override
    public BookDo getBookWithId(int id) {
        Session session = sessionManager.session();
        return (BookDo) session.get(BookDo.class, id);
    }
}
