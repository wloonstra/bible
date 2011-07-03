package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.util.BibleTextBuilder.aBibleText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.BookDo;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
public class BibleTextRepositoryIntegrationTest {
    
    private static final String NO_MOTIVATION = null;
    
    private static BibleTextDo storedText1;
    private static BibleTextDo storedText2;
    
    @Autowired
    private BibleTextRepository repository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void retrieveBibleTexts() throws Exception {
        List<BibleTextDo> bibleTexts = repository.getLatestBibleTexts(3);
        assertThat(bibleTexts.size(), is(3));
    }
    
    @Test
    public void retrieveByUser() throws Exception {
        UserDo user1 = userRepository.store(newUser("firstUser"));
        UserDo user2 = userRepository.store(newUser("secondUser"));
        
        placeTwoAdsFor(user1);
        placeAdsFor(1, user2);
        
        List<BibleTextDo> bibleTexts = repository.getBibleTextsForUser(user1.getId());
        assertThat(bibleTexts.size(), is(2));
        assertThat(bibleTexts.get(0).getId(), is(storedText1.getId()));
        assertThat(bibleTexts.get(1).getId(), is(storedText2.getId()));
    }

    private static BibleTextDo newBibleTextFor(BookDo book, int startChapter, int startVerse, int endChapter, int endVerse, String motivation, UserDo user) {
        return aBibleText().inBook(book)
                           .startsAtChapter(startChapter)
                           .startsAtVerse(startVerse)
                           .endsAtChapter(endChapter)
                           .endsWithVerse(endVerse)
                           .withMotivation(motivation)
                           .addedBy(user)
                           .build();
    }
    
    private static UserDo newUser(String userName) {
        UserDo user = new UserDo();
        user.setUsername(userName);
        return user;
    }
    
    private void placeTwoAdsFor(UserDo user) {
        BookDo leviticus = bookWithName("Leviticus");
        
        storedText1 = repository.store(newBibleTextFor(leviticus, 1, 2, 3, 4, NO_MOTIVATION, user));
        storedText2 = repository.store(newBibleTextFor(leviticus, 10, 11, 12, 13, "Motivation", user));
    }
    
    private void placeAdsFor(int number, UserDo user) {
        BookDo leviticus = bookWithName("Leviticus");
        for (int index = 0; index < number; index++) {
            repository.store(newBibleTextFor(leviticus, 100, 101, 102, 103, NO_MOTIVATION, user));
        }
    }
    
    private BookDo bookWithName(String bookName) {
        BookDo leviticus = bookRepository.getBookWithName(bookName);
        return leviticus;
    }

}
