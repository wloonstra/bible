package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.hibernate.factory.BibleTextRepositoryFactory.bibleTextRepository;
import static nl.wiggertloonstra.bible.util.BibleTextBuilder.aBibleText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.domain.Book;
import nl.wiggertloonstra.bible.domain.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class BibleTextRepositoryIntegrationTest {
    
    private static final Book LEVITICUS = new HibernateBookRepository().getBookWithName("Leviticus");
    private static final User USER1 = new UserRepository().store(newUser("firstUser"));
    private static final User USER2 = new UserRepository().store(newUser("secondUser"));
    private static final String NO_MOTIVATION = null;
    
    private static BibleText storedText1;
    private static BibleText storedText2;
    
    @BeforeClass
    public static void setup() {
        BibleTextRepository repository = bibleTextRepository();
        storedText1 = repository.store(newBibleTextFor(LEVITICUS, 1, 2, 3, 4, NO_MOTIVATION, USER1));
        storedText2 = repository.store(newBibleTextFor(LEVITICUS, 10, 11, 12, 13, "Motivation", USER1));
        repository.store(newBibleTextFor(LEVITICUS, 100, 101, 102, 103, NO_MOTIVATION, USER2));
    }

    @Test
    public void retrieveBibleTexts() throws Exception {
        BibleTextRepository bibleTextRepository = bibleTextRepository();
        List<BibleText> bibleTexts = bibleTextRepository.getLatestBibleTexts(3);
        assertThat(bibleTexts.size(), is(3));
    }
    
    @Test
    public void retrieveByUser() throws Exception {
        BibleTextRepository bibleTextRepository = bibleTextRepository();
        List<BibleText> bibleTexts = bibleTextRepository.getBibleTextsForUser(USER1.getId());
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
}
