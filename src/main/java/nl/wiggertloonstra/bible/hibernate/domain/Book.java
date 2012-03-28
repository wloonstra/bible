package nl.wiggertloonstra.bible.hibernate.domain;

import javax.persistence.Column;
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
    
    @Column(name = "testament")
    private int testamentInt;
    
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

    public int getTestamentInt() {
        return testamentInt;
    }

    public void setTestamentInt(int testamentInt) {
        this.testamentInt = testamentInt;
    }
    
    public Testament getTestament() {
        Testament testament = Testament.NEW_TESTAMENT.getById(testamentInt);
        return testament;
    }
    
    
}
