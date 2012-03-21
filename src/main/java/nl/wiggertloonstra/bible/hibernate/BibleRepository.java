package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleComment;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.Book;
import nl.wiggertloonstra.bible.ui.view.BibleTextView;

/**
 * BibleTextRepository to store and retrieve bibleTexts.
 * @author wloonstra
 */
public interface BibleRepository {

    BibleTextDo store(BibleTextDo newBibleText);
    List<BibleTextView> getBibleTextsForUser(int userId);
    List<BibleTextView> getLatestBibleTexts(int numberOfResults);
    List<BibleTextView> getBibleTextsForCategory(Integer categoryId);
    List<BibleComment> getBibleCommentDosFor(int bibleTextId);
    void addBibleComment(BibleComment bibleComment);
    List<Book> getBooks();
    Book getBookByName(String bookName);
    Book getBookById(int id);
    Book getBookByShortName(String shortname);

}