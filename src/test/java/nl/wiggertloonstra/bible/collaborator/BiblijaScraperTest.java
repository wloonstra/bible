package nl.wiggertloonstra.bible.collaborator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import nl.wiggertloonstra.bible.hibernate.BookRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=false)
public class BiblijaScraperTest {
    
    @Autowired 
    private BiblijaScraper biblijaScraper;
    
    @Autowired
    private BookRepository bookRepository;
    
    
    @Test
    public void findValidText() throws Exception {
        BibleTextDo bibleTextDo = new BibleTextDo();
        bibleTextDo.setBook(bookRepository.getBookWithName("Psalmen"));
        bibleTextDo.setStartChapter(86);
        bibleTextDo.setStartVerse(12);
        
        String actualText = biblijaScraper.findFor(bibleTextDo);
        
        assertThat(actualText, is("12 U, Heer, mijn God, zal ik loven met heel mijn hart, \n uw naam voor eeuwig prijzen."));
    }
    
    @Test
    public void testname() throws Exception {
        BibleTextDo bibleTextDo = new BibleTextDo();
        bibleTextDo.setBook(bookRepository.getBookWithName("Psalmen"));
        bibleTextDo.setStartChapter(151);
        bibleTextDo.setStartVerse(1);
        
        String actualText = biblijaScraper.findFor(bibleTextDo);
        
        assertThat(actualText, is("(Tekst niet gevonden)"));
    }

}
