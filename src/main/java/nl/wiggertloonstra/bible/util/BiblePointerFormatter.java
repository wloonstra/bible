package nl.wiggertloonstra.bible.util;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.BibleVerse;

public class BiblePointerFormatter {

    public static String format(BibleTextDo bibleText) {
        StringBuilder pointer = new StringBuilder(bibleText.getBook().getName());
        pointer.append(" ");
        pointer.append(bibleText.getStartChapter());
        pointer.append(":");
        pointer.append(bibleText.getStartVerse());
        if (additionalVerse(bibleText)) {
            pointer.append("-");
            if (endChapterDifferent(bibleText)) {
                pointer.append(bibleText.getEndChapter());
                pointer.append(":");
            }
            pointer.append(bibleText.getEndVerse());
        }
        return pointer.toString();
    }


    public static String format(BibleVerse bibleVerse) {
        StringBuilder pointer = new StringBuilder(bibleVerse.getBook().getName());
        pointer.append(" ");
        pointer.append(bibleVerse.getChapter());
        pointer.append(":");
        pointer.append(bibleVerse.getVerse());
        return pointer.toString();
    }

    private static boolean additionalVerse(BibleTextDo bibleText) {
        return bibleText.getEndVerse() > 0 && bibleText.getStartVerse() != bibleText.getEndVerse();
    }

    private static boolean endChapterDifferent(BibleTextDo bibleText) {
        return bibleText.getEndChapter() > 0 && bibleText.getStartChapter() != bibleText.getEndChapter();
    }

}
