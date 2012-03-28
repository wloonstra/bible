package nl.wiggertloonstra.bible.ui.view;

import static com.google.common.collect.Lists.newArrayList;
import static nl.wiggertloonstra.bible.ui.view.BibleTextView.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

import nl.wiggertloonstra.bible.hibernate.domain.BibleVerse;
import org.junit.Test;

public class BibleTextViewTest {
    
    private static final String LESS_THAN_MINIMUM_VISIBLE_TEXT = n(TEXT_SNIPPET_LENGTH_NOT_TOO_SHORTEN - TEXT_SNIPPET_DELTA - 30);
    private static final String MINIMUM_VISIBLE_TEXT = n(TEXT_SNIPPET_LENGTH_NOT_TOO_SHORTEN - TEXT_SNIPPET_DELTA);
    private static final String MINIMUM_VISIBLE_TEXT_PLUS_A_FEW = n(TEXT_SNIPPET_LENGTH_NOT_TOO_SHORTEN - TEXT_SNIPPET_DELTA + 20);
    private static final String TRESHOLD_NOT_TO_SHORTEN = n(TEXT_SNIPPET_LENGTH_NOT_TOO_SHORTEN - 1);
    private static final String LENGHT_TO_SHORTEN = n(TEXT_SNIPPET_LENGTH_NOT_TOO_SHORTEN);

    @Test
    public void checkSnippet1() {
        checkInputOutputForSnippet("hoi", "hoi");
        checkInputOutputForSnippet("hoi meerdere woorden", "hoi meerdere woorden");
        checkInputOutputForSnippet(LESS_THAN_MINIMUM_VISIBLE_TEXT + " word " + LENGHT_TO_SHORTEN, LESS_THAN_MINIMUM_VISIBLE_TEXT + " word " + LENGHT_TO_SHORTEN + "...");
        checkInputOutputForSnippet(MINIMUM_VISIBLE_TEXT + " word " + LENGHT_TO_SHORTEN, MINIMUM_VISIBLE_TEXT + "...");
        checkInputOutputForSnippet(MINIMUM_VISIBLE_TEXT_PLUS_A_FEW + " word " + LENGHT_TO_SHORTEN, MINIMUM_VISIBLE_TEXT_PLUS_A_FEW + "...");
        checkInputOutputForSnippet(TRESHOLD_NOT_TO_SHORTEN, TRESHOLD_NOT_TO_SHORTEN);
        checkInputOutputForSnippet(TRESHOLD_NOT_TO_SHORTEN + " ", TRESHOLD_NOT_TO_SHORTEN + " ");
        checkInputOutputForSnippet(TRESHOLD_NOT_TO_SHORTEN + "a word", TRESHOLD_NOT_TO_SHORTEN + "a...");
        checkInputOutputForSnippet(TRESHOLD_NOT_TO_SHORTEN + " next", TRESHOLD_NOT_TO_SHORTEN + "...");
        checkInputOutputForSnippet(LENGHT_TO_SHORTEN + "a word", LENGHT_TO_SHORTEN + "a...");        
    }

    private void checkInputOutputForSnippet(String input, String output) {
        BibleVerse bibleVerse = new BibleVerse();
        bibleVerse.setText(input);
        BibleTextDo bibleTextDo = new BibleTextDo();
        bibleTextDo.setBibleVerses(newArrayList(bibleVerse));
        BibleTextView bibleTextView = new BibleTextView(bibleTextDo);
        assertThat(bibleTextView.getTextSnippet(), is(output));
    }

    private static String n(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append("a");
        }
        return sb.toString();

    }

}
