package nl.wiggertloonstra.bible.util;

import nl.wiggertloonstra.bible.hibernate.BookRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BibleInputInterpreter {

    private BookRepository bookRepository;
    private static final String BIBLE_INPUT_PATTERN = "^([a-zA-Z]+)\\s.*$";

    @Autowired
    public BibleInputInterpreter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public BibleTextDo interpret(String bibleInput) {
        Pattern p = Pattern.compile(BIBLE_INPUT_PATTERN);
        Matcher m = p.matcher(bibleInput);
        while(m.find()) {
            bookRepository.getBookWithShortName(m.group(1));
        }
        return new BibleTextDo();

    }
}
