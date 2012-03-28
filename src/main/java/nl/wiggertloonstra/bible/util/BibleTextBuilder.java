package nl.wiggertloonstra.bible.util;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.BibleVerse;
import nl.wiggertloonstra.bible.hibernate.domain.Book;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

import static com.google.common.collect.Lists.newArrayList;

public class BibleTextBuilder {
    
    private Book book;
    private int startChapter;
    private int startVerse;
    private int endChapter;
    private int endVerse;
    private UserDo user;
    private String motivation;
    
    public static BibleTextBuilder aBibleText() {
        return new BibleTextBuilder();
    }
    
    public BibleTextBuilder inBook(Book book) {
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
        
        BibleVerse startBibleVerse = bibleVerse(book, startChapter, startVerse);
        BibleVerse endBibleVerse = bibleVerse(book, endChapter, endVerse);
        
        bibleText.setBibleVerses(newArrayList(startBibleVerse, endBibleVerse));
        bibleText.setUser(user);
        return bibleText;
    }

    private BibleVerse bibleVerse(Book book, int chapter, int verse) {
        BibleVerse firstBibleVerse = new BibleVerse();
        firstBibleVerse.setBook(book);
        firstBibleVerse.setChapter(chapter);
        firstBibleVerse.setVerse(verse);
        return firstBibleVerse;
    }
}
