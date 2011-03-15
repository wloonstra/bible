package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.hibernate.SessionCreator.getSessionFactory;
import static org.hibernate.criterion.Restrictions.like;

import java.util.List;

import nl.wiggertloonstra.bible.domain.Book;

import org.hibernate.classic.Session;

/**
 * Hibernate implementation of BookRepository.
 * @author wloonstra
 */
public class HibernateBookRepository implements BookRepository {
    
    @Override
    public List<Book> getBooks() {
        Session session = SessionCreator.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Book> books = (List<Book>) session.createCriteria(Book.class).list();
        return books;
    }

    @Override
    public Book getBookWithName(String bookName) {
        Session session = getSessionFactory().openSession();
        return (Book) session
                .createCriteria(Book.class)
                .add(like("name", bookName))
                .uniqueResult();
    }
}
