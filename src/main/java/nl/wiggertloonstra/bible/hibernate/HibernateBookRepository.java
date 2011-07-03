package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.hibernate.SessionCreator.getSessionFactory;
import static org.hibernate.criterion.Restrictions.like;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BookDo;

import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;

/**
 * Hibernate implementation of BookRepository.
 * @author wloonstra
 */
@Component
public class HibernateBookRepository implements BookRepository {
    
    @Override
    public List<BookDo> getBooks() {
        Session session = SessionCreator.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<BookDo> books = (List<BookDo>) session.createCriteria(BookDo.class).list();
        return books;
    }

    @Override
    public BookDo getBookWithName(String bookName) {
        Session session = getSessionFactory().openSession();
        return (BookDo) session
                .createCriteria(BookDo.class)
                .add(like("name", bookName))
                .uniqueResult();
    }
}
