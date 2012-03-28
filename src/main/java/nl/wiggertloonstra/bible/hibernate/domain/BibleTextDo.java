package nl.wiggertloonstra.bible.hibernate.domain;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

import java.util.List;

import javax.persistence.*;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

@Entity(name = "bibletext")
public class BibleTextDo {
    
    private static final Function<BibleVerse, String> TO_TEXT = new Function<BibleVerse, String>() {
        @Override
        public String apply(BibleVerse from) {
            return from.getText();
        }
    };
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private UserDo user;
    
    @ManyToOne
    private CategoryDo category;

    @Column(name = "placedate", columnDefinition = "bigint(20)")
    private long placeDate;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bibletext_bibleverse", 
            joinColumns = { @JoinColumn(name = "bibletext_id") },
            inverseJoinColumns = { @JoinColumn(name = "bibleverse_id") })
    private List<BibleVerse> bibleVerses;
    
    @OneToMany
    @JoinTable(name = "bibletext_biblecomment", 
            joinColumns = { @JoinColumn(name = "bibletext_id") },
            inverseJoinColumns = { @JoinColumn(name = "biblecomment_id") })
    private List<BibleComment> comments;

    public BibleTextDo() {
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

    public CategoryDo getCategory() {
        return category;
    }

    public void setCategory(CategoryDo category) {
        this.category = category;
    }

    public long getPlaceDate() {
        return placeDate;
    }

    public void setPlaceDate(long placeDate) {
        this.placeDate = placeDate;
    }

    public List<BibleVerse> getBibleVerses() {
        return bibleVerses;
    }

    public void setBibleVerses(List<BibleVerse> bibleVerses) {
        this.bibleVerses = bibleVerses;
    }

    public List<BibleComment> getComments() {
        return comments;
    }

    public void setComments(List<BibleComment> comments) {
        this.comments = comments;
    }
    
    public Book getBook() {
        return startVerse().getBook();
    }
    
    public String getText() {
        return Joiner.on(" ").join(transform(bibleVerses, TO_TEXT));
    }
    
    public int getStartChapter() {
        return startVerse().getChapter();
    }
    
    public int getEndChapter() {
        return endVerse().getChapter();
    }
    
    public int getStartVerse() {
        return startVerse().getVerse();
    }
    
    public int getEndVerse() {
        return endVerse().getVerse();
    }
    
    public void setBibleVerses(Book book, int chapter, int startVerse, int endVerse) {
        List<BibleVerse> bibleVerses = newArrayList();
        for (int verse = startVerse; verse <= endVerse; verse++) {
            bibleVerses.add(new BibleVerse(book, chapter, verse));
        }
        this.bibleVerses = bibleVerses;
        
    }
    
    private BibleVerse startVerse() {
        return bibleVerses.get(0);
    }
    
    private BibleVerse endVerse() {
        return bibleVerses.get(bibleVerses.size() - 1);
    }
}
