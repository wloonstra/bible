package nl.wiggertloonstra.bible.ui.controller;

import nl.wiggertloonstra.bible.collaborator.NewTextWorker;
import nl.wiggertloonstra.bible.ui.form.TextForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Servlet to add a new BibleText to the system.
 * @author wloonstra
 */
@Controller
@RequestMapping("/tekst-toevoegen.html")
public class AddTextController {

    private static final long serialVersionUID = 1543664454861739482L;
    private final NewTextWorker newTextWorker;
    
    @Autowired
    public AddTextController(NewTextWorker newTextWorker) {
        this.newTextWorker = newTextWorker;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String seePage(@ModelAttribute TextForm textForm) {
        return "addText";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addText(@ModelAttribute TextForm textForm) {
        newTextWorker.add(textForm.toBibleTextDto());
        return "redirect:overzicht";
    }
}
