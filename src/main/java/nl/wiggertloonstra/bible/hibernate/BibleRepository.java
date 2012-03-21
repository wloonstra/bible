package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleComment;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.Book;

/**
 * BibleTextRepository to store and retrieve bibleTexts.
 * @author wloonstra
 */
public interface BibleRepository {

    BibleTextDo store(BibleTextDo newBibleText);
    List<BibleTextDo> getBibleTextsForUser(int userId);
    List<BibleTextDo> getLatestBibleTexts(int numberOfResults);
    List<BibleTextDo> getBibleTextsForCategory(Integer categoryId);
    List<BibleComment> getBibleCommentDosFor(int bibleTextId);
    void addBibleComment(BibleComment bibleComment);
    List<Book> getBooks();
    Book getBookByName(String bookName);
    Book getBookById(int id);
    Book getBookByShortName(String shortname);

}