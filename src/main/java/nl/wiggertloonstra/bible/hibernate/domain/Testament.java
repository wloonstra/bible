package nl.wiggertloonstra.bible.hibernate.domain;

public enum Testament {
    OLD_TESTAMENT(0),
    NEW_TESTAMENT(1);
    
    private final int id;

    private Testament(int id) {
        this.id = id;
    }
    
    public Testament getById(int id) {
        for (Testament testament : values()) {
            if (testament.getId() == id) {
                return testament;
            }
        }
        throw new IllegalArgumentException("Testament not found for id: " + id);
    }

    private int getId() {
        return id;
    }
}