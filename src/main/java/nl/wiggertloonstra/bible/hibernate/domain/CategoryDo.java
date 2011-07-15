package nl.wiggertloonstra.bible.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "category")
public class CategoryDo {
    
    @Id
    private int id;
    private String name;
    
    public CategoryDo() {
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
