package nl.wiggertloonstra.bible.ui.form;

import nl.wiggertloonstra.bible.dto.BibleTextDto;

public class TextFormInput {
    
    private String book;
    private int startChapter;
    private int startVerse;
    private int endChapter;
    private int endVerse;
    private String motivation;
    
    public String getBook() {
        return book;
    }
    public void setBook(String book) {
        this.book = book;
    }
    public int getStartChapter() {
        return startChapter;
    }
    public void setStartChapter(int startChapter) {
        this.startChapter = startChapter;
    }
    public int getStartVerse() {
        return startVerse;
    }
    public void setStartVerse(int startVerse) {
        this.startVerse = startVerse;
    }
    public int getEndChapter() {
        return endChapter;
    }
    public void setEndChapter(int endChapter) {
        this.endChapter = endChapter;
    }
    public int getEndVerse() {
        return endVerse;
    }
    public void setEndVerse(int endVerse) {
        this.endVerse = endVerse;
    }
    public String getMotivation() {
        return motivation;
    }
    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }
    
    public BibleTextDto toBibleTextDto() {
        BibleTextDto bibleTextDto = new BibleTextDto();
        bibleTextDto.bookName = book;
        bibleTextDto.startChapter = this.startChapter;
        bibleTextDto.startVerse = this.startVerse;
        bibleTextDto.endChapter = this.endChapter;
        bibleTextDto.endVerse = this.endVerse;
        bibleTextDto.motivation = this.motivation;
        return bibleTextDto;
    }

}
