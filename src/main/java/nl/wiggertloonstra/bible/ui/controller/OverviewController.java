package nl.wiggertloonstra.bible.ui.controller;

import java.io.IOException;
import java.util.List;

import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;

@Controller
public class OverviewController {

    private static final String DEFAULT_BIBLIJA_URL = "http://www.biblija.net/biblija.cgi?l=nl&m=";
    List<String> texts = Lists.newArrayList();
    private WebDriver driver;
    private final BibleTextRepository bibleTextRepository;

    @Autowired
    public OverviewController(BibleTextRepository bibleTextRepository) {
        this.bibleTextRepository = bibleTextRepository;
        driver = new HtmlUnitDriver();
        texts.add("Gen+1:1-10");
        texts.add("Mat+2:1-5");
        texts.add("Ruth+3:1-8");
        texts.add("Mal+1:3-7");
        texts.add("Joh+3:16");
        texts.add("1+Kor+15:58");
    }
    
    @RequestMapping("/overzicht.html")
    public String overview(Model model) throws ClientProtocolException, IOException {
        List<BibleText> latestBibleTexts = bibleTextRepository.getLatestBibleTexts(10);
        model.addAttribute("bibleTexts", latestBibleTexts);
        
        model.addAttribute("liveBibleText", seleniumBibleText());
        
        return "overview";
    }

    private String seleniumBibleText() {
        driver.get(DEFAULT_BIBLIJA_URL + texts.get((int) (Math.random() * texts.size())));
        return driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td[@class = 'text']")).getText();
    }
}
