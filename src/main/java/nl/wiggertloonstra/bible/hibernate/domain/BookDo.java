package nl.wiggertloonstra.bible.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Represents a Bible book in Dutch names
 * @author wloonstra
 */
@Entity(name = "book")
public class BookDo {

    @Id
    private int id;
    private String name;
    
    public BookDo() {
        // empty constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
