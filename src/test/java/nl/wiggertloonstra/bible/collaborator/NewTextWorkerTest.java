package nl.wiggertloonstra.bible.collaborator;

import static nl.wiggertloonstra.bible.testutil.BibleTextTestUtil.createDefaultBibleText;
import static nl.wiggertloonstra.bible.testutil.BibleTextTestUtil.createDefaultBibleTextDto;
import static nl.wiggertloonstra.bible.testutil.BibleTextTestUtil.isEqualBibleTexts;
import static nl.wiggertloonstra.bible.testutil.BookTestUtil.aBookWithId;
import static org.easymock.EasyMock.expect;
import nl.wiggertloonstra.bible.dto.BibleTextDto;
import nl.wiggertloonstra.bible.hibernate.BibleRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.service.CategoryService;
import nl.wiggertloonstra.bible.service.UserService;

import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.easymock.IMocksControl;
import org.junit.Test;

public class NewTextWorkerTest {
    
    private final IMocksControl control = EasyMock.createControl();
    private BibleRepository bibleRepository = control.createMock(BibleRepository.class);
    private UserService userService = control.createMock(UserService.class);
    private CategoryService categoryService = control.createMock(CategoryService.class);
    NewTextWorker addNewTextWorker = new NewTextWorker(bibleRepository, userService, categoryService);
    
    @Test
    public void addsNewTextToBibleTextRepository() throws Exception {
        BibleTextDto bibleTextDto = createDefaultBibleTextDto();
        expect(bibleRepository.getBookById(1)).andReturn(aBookWithId(1));
        expect(bibleRepository.store(aBibleTextWithCorrectFields())).andReturn(null);
        expect(categoryService.getCategoryDoFor(0)).andReturn(null);
        expect(userService.userExistingOrNewWithEmail(null)).andReturn(null);
        
        control.replay();
        addNewTextWorker.add(bibleTextDto);
        control.verify();
    }

    private BibleTextDo aBibleTextWithCorrectFields() {
        EasyMock.reportMatcher(new IArgumentMatcher() {
            
            @Override
            public boolean matches(Object bibleText) {
                BibleTextDo actualBibleText = (BibleTextDo) bibleText;
                BibleTextDo expectedBibleText = createDefaultBibleText();
                return isEqualBibleTexts(expectedBibleText, actualBibleText);
            }

            @Override
            public void appendTo(StringBuffer buffer) {
                buffer.append("A bibleText with the right fields");
            }
        });
        return null;
    }
}
