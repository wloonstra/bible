package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.domain.BibleText;

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
    BibleText store(BibleText newBibleText);
    
    /**
     * Retrieve all bible texts for a given user.
     * @param userId for which the bible texts are retrieved
     * @return list of retrieved bibleTexts
     */
    List<BibleText> getBibleTextsForUser(int userId);
    
    /**
     * @param numberOfResults to return
     * @return list of latest ten bible texts 
     */
    List<BibleText> getLatestBibleTexts(int numberOfResults);

}