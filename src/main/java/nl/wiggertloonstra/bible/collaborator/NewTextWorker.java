package nl.wiggertloonstra.bible.collaborator;

import nl.wiggertloonstra.bible.dto.BibleTextDto;
import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.BookRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.Book;
import nl.wiggertloonstra.bible.hibernate.domain.CategoryDo;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;
import nl.wiggertloonstra.bible.service.CategoryService;
import nl.wiggertloonstra.bible.service.UserService;

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
    private final UserService userService;
    private final CategoryService categoryService;
    
    @Autowired
    public NewTextWorker(BibleTextRepository bibleTextRepository,
                         BookRepository bookRepository,
                         UserService userService,
                         CategoryService categoryService) {
        this.bibleTextRepository = bibleTextRepository;
        this.bookRepository = bookRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    /**
     * Add a bibleTextDto to the bibleTextRepository.
     * @param bibleTextDto to add
     */
    public void add(BibleTextDto bibleTextDto) {
        Book book = retrieveBookFrom(bibleTextDto);
        CategoryDo category = retrieveCategoryFrom(bibleTextDto);
        UserDo user = retrieveUserFrom(bibleTextDto);
        
        BibleTextDo newBibleText = new BibleTextDo();
        newBibleText.setBook(book);
        newBibleText.setMotivation(bibleTextDto.motivation);
        newBibleText.setStartChapter(bibleTextDto.startChapter);
        newBibleText.setStartVerse(bibleTextDto.startVerse);
        newBibleText.setEndChapter(bibleTextDto.endChapter);
        newBibleText.setEndVerse(bibleTextDto.endVerse);
        newBibleText.setCategory(category);
        newBibleText.setUser(user);
        bibleTextRepository.store(newBibleText);
    }
    
    private Book retrieveBookFrom(BibleTextDto bibleTextDto) {
        return bookRepository.getBookWithId(bibleTextDto.bookId);
    }

    private CategoryDo retrieveCategoryFrom(BibleTextDto bibleTextDto) {
        return categoryService.getCategoryDoFor(bibleTextDto.categoryId);
    }

    private UserDo retrieveUserFrom(BibleTextDto bibleTextDto) {
        return userService.userExistingOrNewWithEmail(bibleTextDto.email);
    }
}
