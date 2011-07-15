package nl.wiggertloonstra.bible.ui.controller;

import java.io.IOException;
import java.util.List;

import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.CategoryRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OverviewController {

    private static final String DEFAULT_BIBLIJA_URL = "http://www.biblija.net/biblija.cgi?l=nl&m=";
    List<String> texts = TextOverviewHelper.defaultTexts();
    private WebDriver driver;
    private final BibleTextRepository bibleTextRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public OverviewController(BibleTextRepository bibleTextRepository,
                              CategoryRepository categoryRepository) {
        this.bibleTextRepository = bibleTextRepository;
        this.categoryRepository = categoryRepository;
        driver = new HtmlUnitDriver();
    }
    
    @RequestMapping("/overzicht.html")
    public String overview(Model model) throws ClientProtocolException, IOException {
        List<BibleTextDo> latestBibleTexts = bibleTextRepository.getLatestBibleTexts(10);
        model.addAttribute("bibleTexts", latestBibleTexts);
        model.addAttribute("categories", categoryRepository.getAllCategories());
        
        model.addAttribute("liveBibleText", seleniumBibleText());
        
        return "overview";
    }

    private String seleniumBibleText() {
        driver.get(DEFAULT_BIBLIJA_URL + texts.get((int) (Math.random() * texts.size())));
        return driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td[@class = 'text']")).getText();
    }
}
