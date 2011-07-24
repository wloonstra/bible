package nl.wiggertloonstra.bible.ui.view;

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
    
    public String getMotivation() {
        return bibleTextDo.getMotivation();
    }
    
    public String getText() {
        return bibleTextDo.getText();
    }
    
    public String getEmail() {
        return bibleTextDo.getUser().getUsername();
    }

}
