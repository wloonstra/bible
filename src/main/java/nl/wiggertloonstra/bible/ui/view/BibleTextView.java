package nl.wiggertloonstra.bible.ui.view;

import java.util.List;

import nl.wiggertloonstra.bible.contants.Urls;
import nl.wiggertloonstra.bible.hibernate.domain.BibleComment;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;
import nl.wiggertloonstra.bible.util.BiblePointerFormatter;

public class BibleTextView {
    
    public static final int TEXT_SNIPPET_LENGTH_NOT_TOO_SHORTEN = 200;
    public static final int TEXT_SNIPPET_DELTA = 70;

    private final BibleTextDo bibleTextDo;

    public BibleTextView(BibleTextDo bibleTextDo) {
        this.bibleTextDo = bibleTextDo;
    }
    
    public String getTextPointer() {
        return BiblePointerFormatter.format(bibleTextDo);
    }
    
    public List<BibleComment> getComments() {
        return bibleTextDo.getComments();
    }
    
    public String getTextSnippet() {
        String text = bibleTextDo.getText();
        if (text.trim().length() < TEXT_SNIPPET_LENGTH_NOT_TOO_SHORTEN) {
            return text;
        }
        
        int breakpoint = findSpaceAfterSnippetLength(text);
        return bibleTextDo.getText().substring(0, breakpoint) + "...";
    }
    
    private int findSpaceAfterSnippetLength(String text) {
        int breakpoint = TEXT_SNIPPET_LENGTH_NOT_TOO_SHORTEN - TEXT_SNIPPET_DELTA;
        while (breakpoint < text.length() && !text.substring(breakpoint, breakpoint+1).equals(" ")) {
            breakpoint++;
        }
        return breakpoint;
    }

    public String getFullText() {
        return bibleTextDo.getText();
    }
    
    public Integer getId() {
        return bibleTextDo.getId();
    }
    
    public UserDo getUser() {
        return bibleTextDo.getUser();
    }
    
    public Integer getCategoryId() {
        return bibleTextDo.getCategory().getId();
    }
    
    public String getUrl() {
        return Urls.INSTANCE.viewtext(bibleTextDo.getId());
    }

}
