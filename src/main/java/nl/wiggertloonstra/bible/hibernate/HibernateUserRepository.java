package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.hibernate.SessionCreator.getSessionFactory;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class HibernateUserRepository implements UserRepository {

    private HibernateUserRepository() {}
    
    @Override
    public UserDo store(UserDo newUser) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        UserDo storedUser = null;
        
        try {
            tx = session.beginTransaction();
            storedUser = (UserDo) session.merge(newUser);
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

    @Override
    public UserDo getUserWithId(int userId) {
        Session session = getSessionFactory().openSession();
        return (UserDo) session.get(UserDo.class, userId);
    }
}
