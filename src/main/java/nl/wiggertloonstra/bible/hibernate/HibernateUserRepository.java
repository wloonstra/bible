package nl.wiggertloonstra.bible.hibernate;

import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateUserRepository implements UserRepository {

    private final SessionManager sessionManager;

    @Autowired
    public HibernateUserRepository(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    
    @Override
    public UserDo store(UserDo newUser) {
        Session session = sessionManager.session();
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
        Session session = sessionManager.session();
        return (UserDo) session.get(UserDo.class, userId);
    }
}
