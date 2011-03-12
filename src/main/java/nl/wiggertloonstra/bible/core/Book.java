package nl.wiggertloonstra.bible.core;

/**
 * Represents the Bible books in Dutch names
 * @author wloonstra
 */
public enum Book {
    GENESIS("Genesis"),
    EXODUS("Exodus"),
    NUMERI("Numeri"),
    LEVITICUS("Leviticus"),
    DEUTERONOMIUM("Deuteronomium"),
    JOZUA("Jozua"),
    RICHTEREN("Richteren"),
    RUTH("Ruth"),
    EEN_SAMUEL("1 Samu‘l"),
    TWEE_SAMUEL("2 Samu‘l"),
    EEN_KONINGEN("1 Koningen"),
    TWEE_KONINGEN("2 Koningen"),
    EEN_KRONIEKEN("1 Kronieken"),
    TWEE_KRONIEKEN("2 Kronieken"),
    EZRA("Ezra"),
    NEHEMIA("Nehemia"),
    ESTER("Ester"),
    JOB("Job"),
    PSALMEN("Psalmen"),
    SPREUKEN("Spreuken"),
    PREDIKER("Prediker"),
    HOOGLIED("Hooglied"),
    JESAJA("Jesaja");

    private String screenName;
    
    private Book(String screenName) {
        this.screenName = screenName;
    }

    /**
     * @return screenName of Book
     */
    public String getScreenName() {
        return screenName;
    }
    
    /**
     * Find Book by screenName.
     * Or return Genesis if nothing found.
     * @param screenName to find Book for
     * @return Book
     */
    public static Book findBy(String screenName) {
        for (Book book : values()) {
            if (screenName.equals(book.getScreenName())) {
                return book;
            }
        }
        return GENESIS;
    }
}
