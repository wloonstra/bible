package nl.wiggertloonstra.bible.format;

import static nl.wiggertloonstra.bible.util.BibleTextBuilder.aBibleText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.util.BiblePointerFormatter;

import org.junit.Test;

public class BiblePointerFormatterTest {
    
    @Test
    public void createNameForWithinOneChapter() throws Exception {
        BibleText text = aBibleText()
                         .withBook("Exodus")
                         .withStartChapter(5)
                         .withStartVerse(1)
                         .withEndVerse(10)
                         .build();
        String biblePointer = BiblePointerFormatter.format(text);
        
        assertThat(biblePointer, is("Exodus 5:1-10"));
    }

    @Test
    public void createsNameForMoreChapters() throws Exception {
        BibleText text = aBibleText()
                         .withBook("1 Petrus")
                         .withStartChapter(5)
                         .withStartVerse(1)
                         .withEndChapter(7)
                         .withEndVerse(23)
                         .build();
        String biblePointer = BiblePointerFormatter.format(text);
        
        assertThat(biblePointer, is("1 Petrus 5:1-7:23"));
    }
    
    @Test
    public void shouldNotShowSameEndChapters() throws Exception {
        BibleText text = aBibleText()
                         .withBook("1 Petrus")
                         .withStartChapter(5)
                         .withStartVerse(1)
                         .withEndChapter(5)
                         .withEndVerse(23)
                         .build();
        String biblePointer = BiblePointerFormatter.format(text);

        assertThat(biblePointer, is("1 Petrus 5:1-23"));
    }
}
