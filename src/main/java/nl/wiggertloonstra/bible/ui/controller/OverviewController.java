package nl.wiggertloonstra.bible.ui.controller;

import java.util.List;

import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.factory.BibleTextRepositoryFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OverviewController {

    @RequestMapping("/overzicht")
    public String overview(Model model) {
        BibleTextRepository bibleTextRepository = BibleTextRepositoryFactory.bibleTextRepository();
        List<BibleText> latestBibleTexts = bibleTextRepository.getLatestBibleTexts(10);
        model.addAttribute("bibleTexts", latestBibleTexts);
        
        return "overview";
    }
}
