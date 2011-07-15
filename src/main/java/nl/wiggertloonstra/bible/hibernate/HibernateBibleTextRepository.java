package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Hibernate implementation of BibleTextRepository.
 * @author wloonstra
 */
@Component
public class HibernateBibleTextRepository implements BibleTextRepository {

    private final SessionManager sessionManager;

    @Autowired
    public HibernateBibleTextRepository(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    
    @Override
    public BibleTextDo store(BibleTextDo newBibleText) {
        Session session = sessionManager.session();
        Transaction tx = null;
        BibleTextDo storedBibleText = null;
        
        try {
            tx = session.beginTransaction();
            storedBibleText = (BibleTextDo) session.merge(newBibleText);
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
        return storedBibleText;
    }

    @Override
    public List<BibleTextDo> getBibleTextsForUser(int userId) {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<BibleTextDo> bibleTextsForUser = (List<BibleTextDo>) session.createCriteria(BibleTextDo.class)
               .add(Restrictions.eq("user.id", userId))
               .list();
        return bibleTextsForUser;
    }

    @Override
    public List<BibleTextDo> getLatestBibleTexts(int numberOfResults) {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<BibleTextDo> bibleTexts = (List<BibleTextDo>) session.createCriteria(BibleTextDo.class)
               .addOrder(Order.desc("id"))
               .setMaxResults(numberOfResults)
               .list();
        return bibleTexts;
    }

}
