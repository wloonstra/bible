package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.hibernate.SessionCreator.getSessionFactory;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

/**
 * Hibernate implementation of BibleTextRepository.
 * @author wloonstra
 */
@Component
public class HibernateBibleTextRepository implements BibleTextRepository {

    @Override
    public BibleTextDo store(BibleTextDo newBibleText) {
        Session session = getSessionFactory().openSession();
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
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<BibleTextDo> bibleTextsForUser = (List<BibleTextDo>) session.createCriteria(BibleTextDo.class)
               .add(Restrictions.eq("user.id", userId))
               .list();
        return bibleTextsForUser;
    }

    @Override
    public List<BibleTextDo> getLatestBibleTexts(int numberOfResults) {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<BibleTextDo> bibleTexts = (List<BibleTextDo>) session.createCriteria(BibleTextDo.class)
               .addOrder(Order.desc("id"))
               .setMaxResults(numberOfResults)
               .list();
        return bibleTexts;
    }

}
