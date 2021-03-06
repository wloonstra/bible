package nl.wiggertloonstra.bible.ui.controller;

import nl.wiggertloonstra.bible.contants.Urls;
import nl.wiggertloonstra.bible.hibernate.BibleRepository;
import nl.wiggertloonstra.bible.ui.view.BibleTextView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewtextController {
    
    private final BibleRepository bibleRepository;

    @Autowired
    public ViewtextController(BibleRepository bibleRepository) {
        this.bibleRepository = bibleRepository;
    }
    
    @RequestMapping("/tekst.html")
    public String viewText(@RequestParam("textId") int textId, Model model) {
        BibleTextView bibleText = bibleRepository.getBibleTextView(textId);
        model.addAttribute("bibleText", bibleText);
        model.addAttribute("backToOverviewLink", Urls.INSTANCE.overview(bibleText.getCategoryId()));
        return "viewtext";
    }

}
