package nl.wiggertloonstra.bible.util;

import nl.wiggertloonstra.bible.hibernate.domain.*;

import static com.google.common.collect.Lists.newArrayList;

public class BibleTextBuilder {
    
    private Book book;
    private int startChapter;
    private int startVerse;
    private int endChapter;
    private int endVerse;
    private CategoryDo category;
    private UserDo user;

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
    
    public BibleTextBuilder withCategory(CategoryDo category) {
        this.category = category;
        return this;
    }
    
    public BibleTextDo build() {
        BibleTextDo bibleText = new BibleTextDo();
        bibleText.setBibleVerses(book, startChapter, startVerse, endVerse);
        bibleText.setUser(user);
        bibleText.setCategory(category);
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
