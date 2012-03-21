package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleComment;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Hibernate implementation of BibleRepository.
 * @author wloonstra
 */
@Component
public class HibernateBibleRepository implements BibleRepository {

    private final SessionManager sessionManager;

    @Autowired
    public HibernateBibleRepository(SessionManager sessionManager) {
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

    @Override
    public List<BibleTextDo> getBibleTextsForCategory(Integer categoryId) {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<BibleTextDo> bibleTexts = (List<BibleTextDo>) session.createCriteria(BibleTextDo.class)
               .add(Restrictions.eq("category.id", categoryId))
               .list();
        return bibleTexts;
    }
    
    @Override
    public List<BibleComment> getBibleCommentDosFor(int bibleTextId) {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<BibleComment> comments = (List<BibleComment>) session.createCriteria(BibleComment.class)
            .add(Restrictions.eq("bibleText.id", bibleTextId))
            .list();
        return comments;
        
    }

    @Override
    public void addBibleComment(BibleComment bibleComment) {
        // TODO Auto-generated method stub
        
    }

}
