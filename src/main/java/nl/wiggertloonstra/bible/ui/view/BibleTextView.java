package nl.wiggertloonstra.bible.ui.view;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleComment;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.util.BiblePointerFormatter;

public class BibleTextView {

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
    
    public String getText() {
        return bibleTextDo.getText();
    }
    
    public String getEmail() {
        return bibleTextDo.getUser().getUsername();
    }

}
