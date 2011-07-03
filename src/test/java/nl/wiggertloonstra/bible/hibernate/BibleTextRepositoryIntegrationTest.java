package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.util.BibleTextBuilder.aBibleText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.domain.Book;
import nl.wiggertloonstra.bible.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
public class BibleTextRepositoryIntegrationTest {
    
    private static final Book LEVITICUS = new HibernateBookRepository().getBookWithName("Leviticus");
    private static final User USER1 = new UserRepository().store(newUser("firstUser"));
    private static final User USER2 = new UserRepository().store(newUser("secondUser"));
    private static final String NO_MOTIVATION = null;
    
    private static BibleText storedText1;
    private static BibleText storedText2;
    
    @Autowired
    private BibleTextRepository repository;
    
    @Test
    public void retrieveBibleTexts() throws Exception {
        List<BibleText> bibleTexts = repository.getLatestBibleTexts(3);
        assertThat(bibleTexts.size(), is(3));
    }
    
    @Test
    public void retrieveByUser() throws Exception {
        placeTwoAdsFor(USER1);
        placeAdsFor(1, USER2);
        
        List<BibleText> bibleTexts = repository.getBibleTextsForUser(USER1.getId());
        assertThat(bibleTexts.size(), is(2));
        assertThat(bibleTexts.get(0).getId(), is(storedText1.getId()));
        assertThat(bibleTexts.get(1).getId(), is(storedText2.getId()));
    }

    private static BibleText newBibleTextFor(Book book, int startChapter, int startVerse, int endChapter, int endVerse, String motivation, User user) {
        return aBibleText().inBook(book)
                           .startsAtChapter(startChapter)
                           .startsAtVerse(startVerse)
                           .endsAtChapter(endChapter)
                           .endsWithVerse(endVerse)
                           .withMotivation(motivation)
                           .addedBy(user)
                           .build();
    }
    
    private static User newUser(String userName) {
        User user = new User();
        user.setUsername(userName);
        return user;
    }
    
    private void placeTwoAdsFor(User user) {
        storedText1 = repository.store(newBibleTextFor(LEVITICUS, 1, 2, 3, 4, NO_MOTIVATION, user));
        storedText2 = repository.store(newBibleTextFor(LEVITICUS, 10, 11, 12, 13, "Motivation", user));
    }
    
    private void placeAdsFor(int number, User user) {
        for (int index = 0; index < number; index++) {
            repository.store(newBibleTextFor(LEVITICUS, 100, 101, 102, 103, NO_MOTIVATION, user));
        }
    }

}
