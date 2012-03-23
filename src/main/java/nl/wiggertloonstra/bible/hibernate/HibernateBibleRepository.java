package nl.wiggertloonstra.bible.hibernate;

import static com.google.common.collect.Lists.newArrayList;
import static org.hibernate.criterion.Restrictions.like;

import java.util.List;

import nl.wiggertloonstra.bible.collaborator.BiblijaScraper;
import nl.wiggertloonstra.bible.hibernate.domain.BibleComment;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.Book;
import nl.wiggertloonstra.bible.ui.view.BibleTextView;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * Hibernate implementation of BibleRepository.
 * @author wloonstra
 */
@Component
public class HibernateBibleRepository implements BibleRepository {

    private static final Function<BibleTextDo, BibleTextView> TO_BIBLETEXT_VIEW = new Function<BibleTextDo, BibleTextView>() {
        @Override
        public BibleTextView apply(BibleTextDo from) {
            return new BibleTextView(from);
        }
    };

    private final SessionManager sessionManager;
    private final BiblijaScraper biblijaScraper;

    @Autowired
    public HibernateBibleRepository(SessionManager sessionManager, BiblijaScraper biblijaScraper) {
        this.sessionManager = sessionManager;
        this.biblijaScraper = biblijaScraper;
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
    public List<BibleTextView> getBibleTextsForUser(int userId) {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<BibleTextDo> bibleTextsForUser = (List<BibleTextDo>) session.createCriteria(BibleTextDo.class)
               .add(Restrictions.eq("user.id", userId))
               .list();
        return prepareForView(bibleTextsForUser);
    }

    @Override
    public List<BibleTextView> getLatestBibleTexts(int numberOfResults) {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<BibleTextDo> bibleTexts = (List<BibleTextDo>) session.createCriteria(BibleTextDo.class)
               .addOrder(Order.desc("id"))
               .setMaxResults(numberOfResults)
               .list();
        return prepareForView(bibleTexts);
    }

    @Override
    public List<BibleTextView> getBibleTextsForCategory(Integer categoryId) {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<BibleTextDo> bibleTexts = (List<BibleTextDo>) session.createCriteria(BibleTextDo.class)
               .add(Restrictions.eq("category.id", categoryId))
               .list();
        return prepareForView(bibleTexts);
    }
    
    @Override
    public List<BibleComment> getBibleCommentsFor(int bibleTextId) {
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
    @Override
    public List<Book> getBooks() {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<Book> books = (List<Book>) session.createCriteria(Book.class).list();
        return books;
    }

    @Override
    public Book getBookByName(String bookName) {
        Session session = sessionManager.session();
        return (Book) session
                .createCriteria(Book.class)
                .add(like("name", bookName))
                .uniqueResult();
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionManager.session();
        return (Book) session.get(Book.class, id);
    }

    @Override
    public Book getBookByShortName(String gen) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
    
    @Override
    public BibleTextView getBibleTextView(int bibleTextId) {
        Session session = sessionManager.session();
        return prepareForView((BibleTextDo) session.get(BibleTextDo.class, bibleTextId));
    }
    
    private BibleTextView prepareForView(BibleTextDo bibleTextDo) {
        return prepareForView(newArrayList(bibleTextDo)).get(0);
        
    }
    
    private List<BibleTextView> prepareForView(List<BibleTextDo> bibleTextDos) {
        makeSureTextsAreAvailableFor(bibleTextDos);
        return Lists.transform(bibleTextDos, TO_BIBLETEXT_VIEW);
    }
    
    private void makeSureTextsAreAvailableFor(List<BibleTextDo> bibleTextDos) {
        for (BibleTextDo bibleTextDo : bibleTextDos) {
            if (StringUtils.isBlank(bibleTextDo.getText())) {
                String text = biblijaScraper.findFor(bibleTextDo);
                bibleTextDo.setText(text);
                store(bibleTextDo);
            }
        }
    }
}
