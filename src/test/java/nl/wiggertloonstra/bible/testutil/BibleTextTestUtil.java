package nl.wiggertloonstra.bible.testutil;

import static nl.wiggertloonstra.bible.testutil.BookTestUtil.aBookWithId;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.dto.BibleTextDto;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

public class BibleTextTestUtil {
    
    public static final int BOOK = 1;
    public static final int START_CHAPTER = 1;
    public static final int START_VERSE = 2;
    public static final int END_CHAPTER = 3;
    public static final int END_VERSE = 4;

    public static BibleTextDto createDefaultBibleTextDto() {
        BibleTextDto bibleTextDto = new BibleTextDto();
        bibleTextDto.bookId = BOOK;
        bibleTextDto.startChapter = START_CHAPTER;
        bibleTextDto.startVerse = START_VERSE;
        bibleTextDto.endChapter = END_CHAPTER;
        bibleTextDto.endVerse = END_VERSE;
        return bibleTextDto;
    }
    
    public static BibleTextDo createDefaultBibleText() {
        BibleTextDo bibleText = new BibleTextDo();
        bibleText.setBibleVerses(aBookWithId(BOOK), START_CHAPTER, START_VERSE, END_VERSE);
        return bibleText;
    }
    
    public static void assertEqualBibleTexts(BibleTextDo text1, BibleTextDo text2) {
        assertThat(isEqualBibleTexts(text1, text2), is(true));
    }
    
    public static boolean isEqualBibleTexts(BibleTextDo text1, BibleTextDo text2) {
        return 
            text1.getBook().getId() == (text2.getBook().getId())
            && text1.getStartChapter() == text2.getStartChapter()
            && text1.getStartVerse() == text2.getStartVerse() 
            && text1.getEndChapter() == text2.getEndChapter()
            && text1.getEndVerse() == text2.getEndVerse()
            && text1.getUser() == text2.getUser();
    }

}
