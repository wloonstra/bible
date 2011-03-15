package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.hibernate.SessionCreator.getSessionFactory;

import java.util.List;

import nl.wiggertloonstra.bible.domain.BibleText;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Hibernate implementation of BibleTextRepository.
 * @author wloonstra
 */
public class HibernateBibleTextRepository implements BibleTextRepository {

    @Override
    public BibleText store(BibleText newBibleText) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        BibleText storedBibleText = null;
        
        try {
            tx = session.beginTransaction();
            storedBibleText = (BibleText) session.merge(newBibleText);
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
    public List<BibleText> getBibleTextsForUser(int userId) {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<BibleText> bibleTextsForUser = (List<BibleText>) session.createCriteria(BibleText.class)
               .add(Restrictions.eq("user.id", userId))
               .list();
        return bibleTextsForUser;
    }

}
