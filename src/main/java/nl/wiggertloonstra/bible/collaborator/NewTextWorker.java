package nl.wiggertloonstra.bible.collaborator;

import nl.wiggertloonstra.bible.dto.BibleTextDto;
import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.BookRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.BookDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * NewTextWorker performs the actual adding of a new BibleText.
 * @author wloonstra
 */
@Component
public class NewTextWorker {

    private final BibleTextRepository bibleTextRepository;
    private final BookRepository bookRepository;
    
    @Autowired
    public NewTextWorker(BibleTextRepository bibleTextRepository,
                         BookRepository bookRepository) {
        this.bibleTextRepository = bibleTextRepository;
        this.bookRepository = bookRepository;
    }

    /**
     * Add a bibleTextDto to the bibleTextRepository.
     * @param bibleTextDto to add
     */
    public void add(BibleTextDto bibleTextDto) {
        BookDo book = retrieveBookFrom(bibleTextDto.bookName);

        BibleTextDo newBibleText = new BibleTextDo();
        newBibleText.setBook(book);
        newBibleText.setMotivation(bibleTextDto.motivation);
        newBibleText.setStartChapter(bibleTextDto.startChapter);
        newBibleText.setStartVerse(bibleTextDto.startVerse);
        newBibleText.setEndChapter(bibleTextDto.endChapter);
        newBibleText.setEndVerse(bibleTextDto.endVerse);
        bibleTextRepository.store(newBibleText);
    }
    

    private BookDo retrieveBookFrom(String bookName) {
        return bookRepository.getBookWithName(bookName);
    }
}
