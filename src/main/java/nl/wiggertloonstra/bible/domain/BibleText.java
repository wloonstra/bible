package nl.wiggertloonstra.bible.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "bibletext")
public class BibleText {
    
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Book book;
    
    private int startChapter;
    private int endChapter;
    private int startVerse;
    private int endVerse;
    
    @ManyToOne
    private User user;

    private String motivation;
    
    
    public BibleText() {
        // empty constructor
    }

    public BibleText(Book book, int startChapter, int endChapter, int startVerse, int endVerse) {
        this.book = book;
        this.startChapter = startChapter;
        this.endChapter = endChapter;
        this.startVerse = startVerse;
        this.endVerse = endVerse;
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

    public int getStartChapter() {
        return startChapter;
    }

    public void setStartChapter(int startChapter) {
        this.startChapter = startChapter;
    }

    public int getEndChapter() {
        return endChapter;
    }

    public void setEndChapter(int endChapter) {
        this.endChapter = endChapter;
    }

    public int getStartVerse() {
        return startVerse;
    }

    public void setStartVerse(int startVerse) {
        this.startVerse = startVerse;
    }

    public int getEndVerse() {
        return endVerse;
    }

    public void setEndVerse(int endVerse) {
        this.endVerse = endVerse;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

}
