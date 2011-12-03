package nl.wiggertloonstra.bible.hibernate;

import static org.hibernate.criterion.Restrictions.like;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.Book;

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
    public List<Book> getBooks() {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<Book> books = (List<Book>) session.createCriteria(Book.class).list();
        return books;
    }

    @Override
    public Book getBookWithName(String bookName) {
        Session session = sessionManager.session();
        return (Book) session
                .createCriteria(Book.class)
                .add(like("name", bookName))
                .uniqueResult();
    }

    @Override
    public Book getBookWithId(int id) {
        Session session = sessionManager.session();
        return (Book) session.get(Book.class, id);
    }

    @Override
    public Book getBookWithShortName(String gen) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
