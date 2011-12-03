package nl.wiggertloonstra.bible.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Represents a Bible book in Dutch names
 * @author wloonstra
 */
@Entity(name = "book")
public class Book {

    @Id
    private int id;
    private String name;
    
    public Book() {
        // empty constructor
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }
}
