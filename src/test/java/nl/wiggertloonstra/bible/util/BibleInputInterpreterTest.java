package nl.wiggertloonstra.bible.util;

import nl.wiggertloonstra.bible.hibernate.BookRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.Book;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Test;

import static nl.wiggertloonstra.bible.util.BibleTextBuilder.aBibleText;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isNull;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BibleInputInterpreterTest {

    private static final Book GENESIS = new Book().setName("Genesis");
    private static final BibleTextDo GEN_5_1_5_6 = aBibleText()
    .inBook(GENESIS)
    .startsAtChapter(5)
    .startsAtVerse(1)
    .endsAtChapter(5)
    .endsWithVerse(6)
    .build();

    private final IMocksControl control = EasyMock.createControl();
    private final BookRepository bookRepository = control.createMock(BookRepository.class);

    BibleInputInterpreter interpreter = new BibleInputInterpreter(bookRepository);

    @Test
    public void check() {
        String bibleInput = "Gen 5: 1-6";

        expect(bookRepository.getBookWithShortName("Gen")).andReturn(GENESIS);

        control.replay();
        BibleTextDo actualBibleText = interpreter.interpret(bibleInput);
        control.verify();

        assertThat(actualBibleText, is(GEN_5_1_5_6));

    }


}
