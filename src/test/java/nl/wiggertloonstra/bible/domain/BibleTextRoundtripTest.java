package nl.wiggertloonstra.bible.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.hibernate.SessionCreator;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class BibleTextRoundtripTest {
    
    @Test
    public void bibleTextCanBeStoredAndRetrieved() throws Exception {
        Session session = SessionCreator.getSessionFactory().openSession();
        
        Book genesis = retrieveBookGenesis(session);
        User storedUser = createStoredUser(session);
        BibleText bibleText = newBibleText(genesis, storedUser);
        
        session.beginTransaction();
        BibleText storedBibleText = (BibleText) session.merge(bibleText);
        session.getTransaction().commit();
        
        session.beginTransaction();
        BibleText retrievedBibleText = (BibleText) session.get(BibleText.class, storedBibleText.getId());
        session.getTransaction().commit();
        
        assertThat(retrievedBibleText.getBook().getName(), is("Genesis"));
        assertThat(retrievedBibleText.getStartChapter(), is(5));
        assertThat(retrievedBibleText.getStartVerse(), is(12));
        assertThat(retrievedBibleText.getEndChapter(), is(6));
        assertThat(retrievedBibleText.getEndVerse(), is(20));
        assertThat(retrievedBibleText.getUser().getUsername(), is("piet"));
        assertThat(retrievedBibleText.getMotivation(), is("Daarom vind ik deze tekst mooi!"));
        
        SessionCreator.getSessionFactory().close();
    }

    private BibleText newBibleText(Book genesis, User storedUser) {
        BibleText bibleText = new BibleText();
        bibleText.setBook(genesis);
        bibleText.setStartChapter(5);
        bibleText.setStartVerse(12);
        bibleText.setEndChapter(6);
        bibleText.setEndVerse(20);
        bibleText.setUser(storedUser);
        bibleText.setMotivation("Daarom vind ik deze tekst mooi!");
        return bibleText;
    }

    private Book retrieveBookGenesis(Session session) {
        Book genesis = (Book) session.createCriteria(Book.class)
            .add(Restrictions.like("name", "Genesis")).uniqueResult();
        return genesis;
    }
    
    private User createStoredUser(Session session) {
        User user = new User();
        user.setUsername("piet");
        session.beginTransaction();
        User storedUser = (User) session.merge(user);
        session.getTransaction().commit();
        return storedUser;
    }

}
