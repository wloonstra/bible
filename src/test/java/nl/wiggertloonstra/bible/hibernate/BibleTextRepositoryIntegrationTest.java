package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.util.BibleTextBuilder.aBibleText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.Book;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;
import nl.wiggertloonstra.bible.ui.view.BibleTextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=true)
public class BibleTextRepositoryIntegrationTest {
    
    private static final String NO_MOTIVATION = null;
    
    private static BibleTextDo storedText1;
    private static BibleTextDo storedText2;
    
    @Autowired
    private BibleRepository repository;
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void getTextsForCategory() throws Exception {
        assertThat(repository.getBibleTextsForCategory(1).size(), is(7));
    }

    @Test
    public void retrieveByUser() throws Exception {
        UserDo user1 = userRepository.store(newUser("firstUser"));
        UserDo user2 = userRepository.store(newUser("secondUser"));
        
        placeTwoTextsFor(user1);
        placeAdsFor(1, user2);
        
        List<BibleTextView> bibleTexts = repository.getBibleTextsForUser(user1.getId());
        assertThat(bibleTexts.size(), is(2));
        assertThat(bibleTexts.get(0).getId(), is(storedText1.getId()));
        assertThat(bibleTexts.get(1).getId(), is(storedText2.getId()));

        List<BibleTextView> latestBibleTexts = repository.getLatestBibleTexts(3);
        assertThat(latestBibleTexts.size(), is(3));
    }

    private static BibleTextDo newBibleTextFor(Book book, int startChapter, int startVerse, int endChapter, int endVerse, UserDo user) {
        return aBibleText().inBook(book)
                           .startsAtChapter(startChapter)
                           .startsAtVerse(startVerse)
                           .endsAtChapter(endChapter)
                           .endsWithVerse(endVerse)
                           .addedBy(user)
                           .build();
    }
    
    private static UserDo newUser(String name) {
        UserDo user = new UserDo();
        user.setName(name);
        return user;
    }
    
    private void placeTwoTextsFor(UserDo user) {
        Book leviticus = bookWithName("Leviticus");
        
        storedText1 = repository.store(newBibleTextFor(leviticus, 1, 2, 3, 4, user));
        storedText2 = repository.store(newBibleTextFor(leviticus, 10, 11, 12, 13, user));
    }
    
    private void placeAdsFor(int number, UserDo user) {
        Book leviticus = bookWithName("Leviticus");
        for (int index = 0; index < number; index++) {
            repository.store(newBibleTextFor(leviticus, 100, 101, 102, 103, user));
        }
    }
    
    private Book bookWithName(String bookName) {
        Book leviticus = repository.getBookByName(bookName);
        return leviticus;
    }

}
