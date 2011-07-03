package nl.wiggertloonstra.bible.collaborator;

import static nl.wiggertloonstra.bible.testutil.BibleTextTestUtil.createDefaultBibleText;
import static nl.wiggertloonstra.bible.testutil.BibleTextTestUtil.createDefaultBibleTextDto;
import static nl.wiggertloonstra.bible.testutil.BibleTextTestUtil.isEqualBibleTexts;
import static nl.wiggertloonstra.bible.testutil.BookTestUtil.aBookWithName;
import static org.easymock.EasyMock.expect;
import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.dto.BibleTextDto;
import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.BookRepository;

import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.easymock.IMocksControl;
import org.junit.Test;

public class AddNewTextWorkerTest {
    
    private final IMocksControl control = EasyMock.createControl();
    BookRepository bookRepository = control.createMock(BookRepository.class);
    BibleTextRepository bibleTextRepository = control.createMock(BibleTextRepository.class);
    NewTextWorker addNewTextWorker = new NewTextWorker(bibleTextRepository, bookRepository);
    
    @Test
    public void addsNewTextToBibleTextRepository() throws Exception {
        BibleTextDto bibleTextDto = createDefaultBibleTextDto();
        expect(bookRepository.getBookWithName("Genesis")).andReturn(aBookWithName("Genesis"));
        expect(bibleTextRepository.store(aBibleTextWithCorrectFields())).andReturn(null);
        
        control.replay();
        addNewTextWorker.add(bibleTextDto);
        control.verify();
    }

    private BibleText aBibleTextWithCorrectFields() {
        EasyMock.reportMatcher(new IArgumentMatcher() {
            
            @Override
            public boolean matches(Object bibleText) {
                BibleText actualBibleText = (BibleText) bibleText;
                BibleText expectedBibleText = createDefaultBibleText();
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
