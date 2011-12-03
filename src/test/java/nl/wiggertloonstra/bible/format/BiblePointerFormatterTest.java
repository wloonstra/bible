package nl.wiggertloonstra.bible.format;

import static nl.wiggertloonstra.bible.util.BibleTextBuilder.aBibleText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.Book;
import nl.wiggertloonstra.bible.util.BiblePointerFormatter;

import org.junit.Test;

public class BiblePointerFormatterTest {
    
    @Test
    public void createNameForWithinOneChapter() throws Exception {
        BibleTextDo text = aBibleText()
                         .inBook(newBook("Exodus"))
                         .startsAtChapter(5)
                         .startsAtVerse(1)
                         .endsWithVerse(10)
                         .build();
        String biblePointer = BiblePointerFormatter.format(text);
        
        assertThat(biblePointer, is("Exodus 5:1-10"));
    }

    @Test
    public void createsNameForMoreChapters() throws Exception {
        BibleTextDo text = aBibleText()
                         .inBook(newBook("1 Petrus"))
                         .startsAtChapter(5)
                         .startsAtVerse(1)
                         .endsAtChapter(7)
                         .endsWithVerse(23)
                         .build();
        String biblePointer = BiblePointerFormatter.format(text);
        
        assertThat(biblePointer, is("1 Petrus 5:1-7:23"));
    }
    
    @Test
    public void shouldNotShowSameEndChapters() throws Exception {
        BibleTextDo text = aBibleText()
                         .inBook(newBook("1 Petrus"))
                         .startsAtChapter(5)
                         .startsAtVerse(1)
                         .endsAtChapter(5)
                         .endsWithVerse(23)
                         .build();
        String biblePointer = BiblePointerFormatter.format(text);

        assertThat(biblePointer, is("1 Petrus 5:1-23"));
    }
    
    @Test
    public void shouldNotShowEndChaptersOrEndVerseIf0() throws Exception {
        BibleTextDo text = aBibleText()
                         .inBook(newBook("1 Petrus"))
                         .startsAtChapter(5)
                         .startsAtVerse(1)
                         .endsAtChapter(0)
                         .endsWithVerse(0)
                         .build();
        String biblePointer = BiblePointerFormatter.format(text);

        assertThat(biblePointer, is("1 Petrus 5:1"));
        
        text = aBibleText()
             .inBook(newBook("1 Petrus"))
             .startsAtChapter(5)
             .startsAtVerse(1)
             .endsAtChapter(5)
             .endsWithVerse(1)
             .build();
        biblePointer = BiblePointerFormatter.format(text);

        assertThat(biblePointer, is("1 Petrus 5:1"));
    }
    
    private Book newBook(String bookName) {
        Book book = new Book();
        book.setName(bookName);
        return book;
    }
}
