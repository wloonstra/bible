package nl.wiggertloonstra.bible.util;

import nl.wiggertloonstra.bible.domain.BibleText;

public class BiblePointerFormatter {

    public static String format(BibleText bibleText) {
        StringBuilder pointer = new StringBuilder(bibleText.getBook().getName());
        pointer.append(" ");
        pointer.append(bibleText.getStartChapter());
        pointer.append(":");
        pointer.append(bibleText.getStartVerse());
        pointer.append("-");
        if (endChapterDifferent(bibleText)) {
            pointer.append(bibleText.getEndChapter());
            pointer.append(":");
        }
        pointer.append(bibleText.getEndVerse());
        return pointer.toString();
    }

    private static boolean endChapterDifferent(BibleText bibleText) {
        return bibleText.getEndChapter() > 0 && bibleText.getStartChapter() != bibleText.getEndChapter();
    }

}