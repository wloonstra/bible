package nl.wiggertloonstra.bible.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.wiggertloonstra.bible.hibernate.BibleRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BibleInputInterpreter {

    private BibleRepository bibleRepository;
    private static final String BIBLE_INPUT_PATTERN = "^([a-zA-Z]+)\\s.*$";

    @Autowired
    public BibleInputInterpreter(BibleRepository bookRepository) {
        this.bibleRepository = bookRepository;
    }
    public BibleTextDo interpret(String bibleInput) {
        Pattern p = Pattern.compile(BIBLE_INPUT_PATTERN);
        Matcher m = p.matcher(bibleInput);
        while(m.find()) {
            bibleRepository.getBookByShortName(m.group(1));
        }
        return new BibleTextDo();

    }
}
