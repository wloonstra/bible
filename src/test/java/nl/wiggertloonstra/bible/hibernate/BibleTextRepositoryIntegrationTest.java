package nl.wiggertloonstra.bible.hibernate;

import static nl.wiggertloonstra.bible.util.BibleTextBuilder.aBibleText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.domain.Book;
import nl.wiggertloonstra.bible.domain.User;

import org.junit.Test;

public class BibleTextRepositoryIntegrationTest {
    
    @Test
    public void storeNewBibleText() throws Exception {
        Book leviticus = new BookRepository().getBookWithName("Leviticus");
        User user = new UserRepository().store(newUser());
        
        BibleText newBibleText1 = aBibleText()
                                 .inBook(leviticus)
                                 .startsAtChapter(5)
                                 .startsAtVerse(10)
                                 .endsAtChapter(6)
                                 .endsWithVerse(20)
                                 .addedBy(user)
                                 .build();
        
        BibleText newBibleText2 = aBibleText()
                                 .inBook(leviticus)
                                 .startsAtChapter(15)
                                 .startsAtVerse(10)
                                 .endsAtChapter(16)
                                 .endsWithVerse(20)
                                 .withMotivation("Motivation")
                                 .addedBy(user)
                                 .build();
        
        BibleTextRepository bibleTextRepository = new BibleTextRepository();
        BibleText storedText1 = bibleTextRepository.store(newBibleText1);
        BibleText storedText2 = bibleTextRepository.store(newBibleText2);
        
        
        List<BibleText> bibleTexts = bibleTextRepository.getBibleTextsForUser(user.getId());
        assertThat(bibleTexts.size(), is(2));
        assertThat(bibleTexts.get(0).getId(), is(storedText1.getId()));
        assertThat(bibleTexts.get(1).getId(), is(storedText2.getId()));
    }

    private User newUser() {
        User user = new User();
        user.setUsername("Henkie");
        return user;
    }

}
