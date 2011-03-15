package nl.wiggertloonstra.bible.collaborator;

import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.domain.Book;
import nl.wiggertloonstra.bible.dto.BibleTextDto;
import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.BookRepository;
import nl.wiggertloonstra.bible.hibernate.HibernateBibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.HibernateBookRepository;

/**
 * NewTextWorker performs the actual adding of a new BibleText.
 * @author wloonstra
 */
public class NewTextWorker {

    private BookRepository bookRepository = new HibernateBookRepository();
    private BibleTextRepository bibleTextRepository = new HibernateBibleTextRepository();

    /**
     * Add a bibleTextDto to the bibleTextRepository.
     * @param bibleTextDto to add
     */
    public void add(BibleTextDto bibleTextDto) {
        Book book = retrieveBookFrom(bibleTextDto.bookName);

        BibleText newBibleText = new BibleText();
        newBibleText.setBook(book);
        newBibleText.setMotivation(bibleTextDto.motivation);
        try {
            newBibleText.setStartChapter(Integer.parseInt(bibleTextDto.startChapter));
            newBibleText.setStartVerse(Integer.parseInt(bibleTextDto.startVerse));
            newBibleText.setEndChapter(Integer.parseInt(bibleTextDto.endChapter));
            newBibleText.setEndVerse(Integer.parseInt(bibleTextDto.endVerse));
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid input!", e);
        }
        
        bibleTextRepository.store(newBibleText);
    }
    

    private Book retrieveBookFrom(String bookName) {
        return bookRepository.getBookWithName(bookName);
    }
    
    /**
     * Override for tests
     * @param bookRepository
     */
    void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    /**
     * Override for tests
     * @param bibleTextRepository
     */
    void setBibleTextRepository(BibleTextRepository bibleTextRepository) {
        this.bibleTextRepository = bibleTextRepository;
    }

}
