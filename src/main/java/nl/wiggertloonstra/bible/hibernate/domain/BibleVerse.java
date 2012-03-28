package nl.wiggertloonstra.bible.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "bibleverse")
public class BibleVerse {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private Book book;
    private int chapter;
    private int verse;
    private String text;
//
//    @ManyToOne
//    private BibleTextDo bibleTextDo;

    public BibleVerse() {
        // empty constructor
    }

    public BibleVerse(Book book, int chapter, int verse) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public int getChapter() {
        return chapter;
    }
    public void setChapter(int chapter) {
        this.chapter = chapter;
    }
    public int getVerse() {
        return verse;
    }
    public void setVerse(int verse) {
        this.verse = verse;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
//    public BibleTextDo getBibleTextDo() {
//        return bibleTextDo;
//    }
//    public void setBibleTextDo(BibleTextDo bibleTextDo) {
//        this.bibleTextDo = bibleTextDo;
//    }


}
