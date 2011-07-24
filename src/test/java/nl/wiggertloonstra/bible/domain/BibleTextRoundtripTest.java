package nl.wiggertloonstra.bible.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.hibernate.SessionManager;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.BookDo;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=false)
public class BibleTextRoundtripTest {
    
    @Autowired
    private SessionManager sessionManager;
    
    @Test
    public void bibleTextCanBeStoredAndRetrieved() throws Exception {
        Session session = sessionManager.session();
        
        BookDo genesis = retrieveBookGenesis(session);
        UserDo storedUser = createStoredUser(session);
        BibleTextDo bibleText = newBibleText(genesis, storedUser);
        
        session.beginTransaction();
        BibleTextDo storedBibleText = (BibleTextDo) session.merge(bibleText);
        session.getTransaction().commit();
        
        session.beginTransaction();
        BibleTextDo retrievedBibleText = (BibleTextDo) session.get(BibleTextDo.class, storedBibleText.getId());
        session.getTransaction().commit();
        
        assertThat(retrievedBibleText.getBook().getName(), is("Genesis"));
        assertThat(retrievedBibleText.getStartChapter(), is(5));
        assertThat(retrievedBibleText.getStartVerse(), is(12));
        assertThat(retrievedBibleText.getEndChapter(), is(6));
        assertThat(retrievedBibleText.getEndVerse(), is(20));
        assertThat(retrievedBibleText.getUser().getUsername(), is("piet"));
        assertThat(retrievedBibleText.getMotivation(), is("Daarom vind ik deze tekst mooi!"));
        
        sessionManager.getSessionFactory().close();
    }

    private BibleTextDo newBibleText(BookDo genesis, UserDo storedUser) {
        BibleTextDo bibleText = new BibleTextDo();
        bibleText.setBook(genesis);
        bibleText.setStartChapter(5);
        bibleText.setStartVerse(12);
        bibleText.setEndChapter(6);
        bibleText.setEndVerse(20);
        bibleText.setUser(storedUser);
        bibleText.setMotivation("Daarom vind ik deze tekst mooi!");
        return bibleText;
    }

    private BookDo retrieveBookGenesis(Session session) {
        BookDo genesis = (BookDo) session.createCriteria(BookDo.class)
            .add(Restrictions.like("name", "Genesis")).uniqueResult();
        return genesis;
    }
    
    private UserDo createStoredUser(Session session) {
        UserDo user = new UserDo();
        user.setUsername("piet");
        session.beginTransaction();
        UserDo storedUser = (UserDo) session.merge(user);
        session.getTransaction().commit();
        return storedUser;
    }

}
