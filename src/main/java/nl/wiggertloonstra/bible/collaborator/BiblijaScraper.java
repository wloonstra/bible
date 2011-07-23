package nl.wiggertloonstra.bible.collaborator;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.util.BiblePointerFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.stereotype.Component;

@Component
public class BiblijaScraper {
    
    private static final String DEFAULT_BIBLIJA_URL = "http://www.biblija.net/biblija.cgi?l=nl&m=";
    private WebDriver driver;
    
    public BiblijaScraper() {
        driver = new HtmlUnitDriver();
    }
    
    public String findFor(BibleTextDo bibleTextDo) {
        driver.get(DEFAULT_BIBLIJA_URL + BiblePointerFormatter.format(bibleTextDo));
        try {
            return driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td[@class = 'text']")).getText();
        } catch (NoSuchElementException e) {
            return "(Tekst niet gevonden)";
        }
    }
}
