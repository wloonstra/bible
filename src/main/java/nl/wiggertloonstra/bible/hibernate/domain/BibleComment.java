package nl.wiggertloonstra.bible.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "biblecomment")
public class BibleComment {
    
    @Id
    @GeneratedValue
    private int id;
    
    @OneToOne
    private UserDo user;
    
    @Column
    private String comment;
    
    @Column(name = "placedate", columnDefinition = "bigint(20)")
    private long placeDate;
    
    @ManyToOne
    private BibleTextDo bibleText;
    
    public BibleComment() {
        // empty constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDo getUser() {
        return user;
    }

    public void setUser(UserDo user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getPlaceDate() {
        return placeDate;
    }

    public void setPlaceDate(long placeDate) {
        this.placeDate = placeDate;
    }

    public BibleTextDo getBibleText() {
        return bibleText;
    }

    public void setBibleText(BibleTextDo bibleText) {
        this.bibleText = bibleText;
    }
    
}
