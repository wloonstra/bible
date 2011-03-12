package nl.wiggertloonstra.bible.util;

import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.domain.Book;

public class BibleTextBuilder {
    
    private Book book;
    private int startChapter;
    private int startVerse;
    private int endChapter;
    private int endVerse;
    
    public static BibleTextBuilder aBibleText() {
        return new BibleTextBuilder();
    }
    
    public BibleTextBuilder withBook(String bookName) {
        Book book = new Book();
        book.setName(bookName);
        this.book = book;
        return this;
    }
    
    public BibleTextBuilder withStartChapter(int startChapter) {
        this.startChapter = startChapter;
        return this;
    }
    
    public BibleTextBuilder withStartVerse(int startVerse) {
        this.startVerse = startVerse;
        return this;
    }
    
    public BibleTextBuilder withEndChapter(int endChapter) {
        this.endChapter = endChapter;
        return this;
    }
    
    public BibleTextBuilder withEndVerse(int endVerse) {
        this.endVerse = endVerse;
        return this;
    }
    
    public BibleText build() {
        BibleText bibleText = new BibleText();
        bibleText.setBook(book);
        bibleText.setStartChapter(startChapter);
        bibleText.setStartVerse(startVerse);
        bibleText.setEndChapter(endChapter);
        bibleText.setEndVerse(endVerse);
        return bibleText;
    }
}
