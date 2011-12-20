package nl.wiggertloonstra.bible.dto;


import org.joda.time.DateTime;

/**
 * Data transfer object for BibleText.
 */
public class BibleTextDto {
    public int bookId;
    public int startChapter;
    public int startVerse;
    public int endChapter;
    public int endVerse;
    public String motivation;
    public int categoryId;
    public String email;
    public DateTime creationDate;
}
