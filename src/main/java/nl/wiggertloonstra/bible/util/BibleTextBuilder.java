package nl.wiggertloonstra.bible.util;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.BookDo;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

public class BibleTextBuilder {
    
    private BookDo book;
    private int startChapter;
    private int startVerse;
    private int endChapter;
    private int endVerse;
    private UserDo user;
    private String motivation;
    
    public static BibleTextBuilder aBibleText() {
        return new BibleTextBuilder();
    }
    
    public BibleTextBuilder inBook(BookDo book) {
        this.book = book;
        return this;
    }
    
    public BibleTextBuilder startsAtChapter(int startChapter) {
        this.startChapter = startChapter;
        return this;
    }
    
    public BibleTextBuilder startsAtVerse(int startVerse) {
        this.startVerse = startVerse;
        return this;
    }
    
    public BibleTextBuilder endsAtChapter(int endChapter) {
        this.endChapter = endChapter;
        return this;
    }
    
    public BibleTextBuilder endsWithVerse(int endVerse) {
        this.endVerse = endVerse;
        return this;
    }
    
    public BibleTextBuilder addedBy(UserDo user) {
        this.user = user;
        return this;
    }
    
    public BibleTextBuilder withMotivation(String motivation) {
        this.motivation = motivation;
        return this;
    }
    
    public BibleTextDo build() {
        BibleTextDo bibleText = new BibleTextDo();
        bibleText.setBook(book);
        bibleText.setStartChapter(startChapter);
        bibleText.setStartVerse(startVerse);
        bibleText.setEndChapter(endChapter);
        bibleText.setEndVerse(endVerse);
        bibleText.setUser(user);
        bibleText.setMotivation(motivation);
        return bibleText;
    }
}
