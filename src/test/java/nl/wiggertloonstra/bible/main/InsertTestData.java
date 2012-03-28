package nl.wiggertloonstra.bible.main;

import nl.wiggertloonstra.bible.hibernate.BibleRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.Book;
import nl.wiggertloonstra.bible.hibernate.domain.CategoryDo;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;
import nl.wiggertloonstra.bible.service.CategoryService;
import nl.wiggertloonstra.bible.service.UserService;
import nl.wiggertloonstra.bible.ui.view.BibleTextView;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

import static nl.wiggertloonstra.bible.util.BibleTextBuilder.aBibleText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=false)
//@Ignore("Don't run normally!")
public class InsertTestData {
    
    private static final int AANBIDDING = 1;
    private static final int AFWIJZING = 2;
    private static final int ANGST = 3;
    
    @Autowired
    private BibleRepository bibleRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Test
    public void insertTestData() throws Exception {
        UserDo wiggert = userService.userExistingOrNewWithEmail("wiggert@example.com");
        UserDo johannes = userService.userExistingOrNewWithEmail("johannes@example.com");
        UserDo petrus = userService.userExistingOrNewWithEmail("petrus@example.com");

        storeText(45, 12, 1, 1, wiggert, AANBIDDING);
        storeText(46, 6, 20, 20, wiggert, AANBIDDING);
        storeText(19, 50, 15, 15, wiggert, AANBIDDING);
        storeText(40, 5, 16, 16, wiggert, AANBIDDING);
        storeText(51, 3, 13, 13, wiggert, AANBIDDING);
        storeText(51, 3, 17, 17, wiggert, AANBIDDING);
        storeText(19, 22, 24, 24, wiggert, AANBIDDING);
        storeText(19, 27, 10, 10, wiggert, AFWIJZING);
        storeText(43, 6, 37, 37, wiggert, AFWIJZING);
        storeText(19, 9, 11, 11, wiggert, AFWIJZING);
        storeText(52, 4, 8, 8, wiggert, AFWIJZING);
        storeText(62, 3, 1, 1, wiggert, AFWIJZING);
        storeText(20, 18, 24, 24, wiggert, AFWIJZING);
        storeText(49, 1, 4, 4, wiggert, AFWIJZING);
        storeText(19, 94, 14, 15, wiggert, AFWIJZING);
        storeText(19, 103, 17, 18, wiggert, ANGST);
        storeText(19, 138, 3, 3, wiggert, ANGST);
        storeText(19, 138, 7, 7, wiggert, ANGST);
        storeText(5, 31, 6, 6, wiggert, ANGST);
        storeText(19, 37, 3, 4, wiggert, ANGST);
        storeText(23, 41, 10, 10, wiggert, ANGST);
        storeText(55, 1, 7, 7, wiggert, ANGST);
        storeText(43, 14, 27, 27, wiggert, ANGST);
        storeText(19, 56, 3, 4, wiggert, ANGST);
        
        System.out.println("Done inserting test data!");
    }

    private void storeText(int bookId, int startChapter, int startVerse, int endVerse, UserDo user, int categoryId) {
        BibleTextDo bibleText = aBibleText().inBook(bookFrom(bookId))
                .startsAtChapter(startChapter)
                .startsAtVerse(startVerse)
                .endsWithVerse(endVerse)
                .addedBy(user)
                .withCategory(categoryFor(categoryId))
                .build();
        bibleRepository.store(bibleText);
    }

    private CategoryDo categoryFor(int categoryId) {
        return categoryService.getCategoryDoFor(categoryId);
    }

    private Book bookFrom(int bookId) {
        return bibleRepository.getBookById(bookId);
    }
}
