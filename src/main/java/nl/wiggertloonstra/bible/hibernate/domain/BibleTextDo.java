package nl.wiggertloonstra.bible.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "bibletext")
public class BibleTextDo {
    
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private BookDo book;
    
    private int startChapter;
    private int endChapter;
    private int startVerse;
    private int endVerse;
    private String text;

    @ManyToOne
    private UserDo user;
    
    private String motivation;
    
    @ManyToOne
    private CategoryDo category;
    
    
    public BibleTextDo() {
        // empty constructor
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public BookDo getBook() {
        return book;
    }

    public void setBook(BookDo book) {
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
    
    public UserDo getUser() {
        return user;
    }

    public void setUser(UserDo user) {
        this.user = user;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public CategoryDo getCategory() {
        return category;
    }

    public void setCategory(CategoryDo category) {
        this.category = category;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
