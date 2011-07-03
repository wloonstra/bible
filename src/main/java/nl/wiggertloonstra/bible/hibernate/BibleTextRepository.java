package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

/**
 * BibleTextRepository to store and retrieve bibleTexts.
 * @author wloonstra
 */
public interface BibleTextRepository {

    /**
     * Store new bibleText.
     * @param newBibleText to store
     * @return stored bibleText
     */
    BibleTextDo store(BibleTextDo newBibleText);
    
    /**
     * Retrieve all bible texts for a given user.
     * @param userId for which the bible texts are retrieved
     * @return list of retrieved bibleTexts
     */
    List<BibleTextDo> getBibleTextsForUser(int userId);
    
    /**
     * @param numberOfResults to return
     * @return list of latest ten bible texts 
     */
    List<BibleTextDo> getLatestBibleTexts(int numberOfResults);

}