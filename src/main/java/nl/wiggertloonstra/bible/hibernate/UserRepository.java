package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.hibernate.SessionCreator.getSessionFactory;
import nl.wiggertloonstra.bible.domain.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepository {

    public User store(User newUser) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        User storedUser = null;
        
        try {
            tx = session.beginTransaction();
            storedUser = (User) session.merge(newUser);
            tx.commit();
        }
        catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return storedUser;
    }

    public User getUserWithId(int userId) {
        Session session = getSessionFactory().openSession();
        return (User) session.get(User.class, userId);
    }
}
