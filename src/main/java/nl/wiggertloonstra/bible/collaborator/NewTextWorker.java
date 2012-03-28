package nl.wiggertloonstra.bible.collaborator;

import nl.wiggertloonstra.bible.dto.BibleTextDto;
import nl.wiggertloonstra.bible.hibernate.BibleRepository;
import nl.wiggertloonstra.bible.hibernate.domain.*;
import nl.wiggertloonstra.bible.service.CategoryService;
import nl.wiggertloonstra.bible.service.UserService;

import org.hibernate.usertype.LoggableUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * NewTextWorker performs the actual adding of a new BibleText.
 * @author wloonstra
 */
@Component
public class NewTextWorker {

    private final BibleRepository bibleRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    
    @Autowired
    public NewTextWorker(BibleRepository bibleRepository,
                         UserService userService,
                         CategoryService categoryService) {
        this.bibleRepository = bibleRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    /**
     * Add a bibleTextDto to the bibleTextRepository.
     * @param text to add
     */
    public void add(BibleTextDto text) {
        Book book = retrieveBookFrom(text);
        CategoryDo category = retrieveCategoryFrom(text);
        UserDo user = retrieveUserFrom(text);
        
        BibleTextDo newBibleText = new BibleTextDo();
        newBibleText.setBibleVerses(book, text.startChapter, text.startVerse, text.endVerse);
        newBibleText.setCategory(category);
        newBibleText.setUser(user);
        bibleRepository.store(newBibleText);
    }
    
    private Book retrieveBookFrom(BibleTextDto bibleTextDto) {
        return bibleRepository.getBookById(bibleTextDto.bookId);
    }

    private CategoryDo retrieveCategoryFrom(BibleTextDto bibleTextDto) {
        return categoryService.getCategoryDoFor(bibleTextDto.categoryId);
    }

    private UserDo retrieveUserFrom(BibleTextDto bibleTextDto) {
        return userService.userExistingOrNewWithEmail(bibleTextDto.email);
    }
}
