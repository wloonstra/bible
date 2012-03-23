package nl.wiggertloonstra.bible.ui.controller;

import nl.wiggertloonstra.bible.hibernate.BibleRepository;

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
        
        model.addAttribute("tekstId", textId);
        
        return "viewtext";
        
    }

}
