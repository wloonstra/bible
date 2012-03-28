package nl.wiggertloonstra.bible.collaborator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.hibernate.BibleRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

import nl.wiggertloonstra.bible.hibernate.domain.BibleVerse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=true)
public class BiblijaScraperTest {
    
    @Autowired 
    private BiblijaScraper biblijaScraper;
    
    @Autowired
    private BibleRepository bibleRepository;
    
    @Test
    public void findValidText() throws Exception {
        BibleVerse bibleVerse = new BibleVerse();
        bibleVerse.setBook(bibleRepository.getBookByName("Psalm"));
        bibleVerse.setChapter(86);
        bibleVerse.setVerse(12);
        
        String actualText = biblijaScraper.findFor(bibleVerse);
        
        assertThat(actualText, is("12 U, Heer, mijn God, zal ik loven met heel mijn hart, \n uw naam voor eeuwig prijzen."));
    }
    
    @Test
    public void testname() throws Exception {
        BibleVerse bibleVerse = new BibleVerse();
        bibleVerse.setBook(bibleRepository.getBookByName("Psalm"));
        bibleVerse.setChapter(151);
        bibleVerse.setVerse(1);
        
        String actualText = biblijaScraper.findFor(bibleVerse);
        
        assertThat(actualText, is("(Tekst niet gevonden)"));
    }

}
