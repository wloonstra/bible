package nl.wiggertloonstra.bible.testutil;

import static nl.wiggertloonstra.bible.testutil.BookTestUtil.aBookWithName;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.dto.BibleTextDto;

public class BibleTextTestUtil {
    
    public static final String BOOK = "Genesis";
    public static final int START_CHAPTER = 1;
    public static final int START_VERSE = 2;
    public static final int END_CHAPTER = 3;
    public static final int END_VERSE = 4;
    public static final String MOTIVATION = "motivation";

    public static BibleTextDto createDefaultBibleTextDto() {
        BibleTextDto bibleTextDto = new BibleTextDto();
        bibleTextDto.bookName = BOOK;
        bibleTextDto.startChapter = Integer.toString(START_CHAPTER);
        bibleTextDto.startVerse = Integer.toString(START_VERSE);
        bibleTextDto.endChapter = Integer.toString(END_CHAPTER);
        bibleTextDto.endVerse = Integer.toString(END_VERSE);
        bibleTextDto.motivation = MOTIVATION;
        return bibleTextDto;
    }
    
    public static BibleText createDefaultBibleText() {
        BibleText bibleText = new BibleText();
        bibleText.setBook(aBookWithName(BOOK));
        bibleText.setStartChapter(START_CHAPTER);
        bibleText.setStartVerse(START_VERSE);
        bibleText.setEndChapter(END_CHAPTER);
        bibleText.setEndVerse(END_VERSE);
        bibleText.setMotivation(MOTIVATION);
        return bibleText;
    }
    
    public static void assertEqualBibleTexts(BibleText text1, BibleText text2) {
        assertThat(isEqualBibleTexts(text1, text2), is(true));
    }
    
    public static boolean isEqualBibleTexts(BibleText text1, BibleText text2) {
        return 
            text1.getBook().getName().equals(text2.getBook().getName())
            && text1.getStartChapter() == text2.getStartChapter()
            && text1.getStartVerse() == text2.getStartVerse() 
            && text1.getEndChapter() == text2.getEndChapter()
            && text1.getEndVerse() == text2.getEndVerse()
            && text1.getMotivation().equals(text2.getMotivation())
            && text1.getUser() == text2.getUser();
    }

}
