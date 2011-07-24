package nl.wiggertloonstra.bible.ui.controller;

import nl.wiggertloonstra.bible.collaborator.NewTextWorker;
import nl.wiggertloonstra.bible.service.CategoryServiceImpl;
import nl.wiggertloonstra.bible.ui.form.TextFormData;
import nl.wiggertloonstra.bible.ui.form.TextFormInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final CategoryServiceImpl categoryService;
    
    @Autowired
    public AddTextController(NewTextWorker newTextWorker,
                             CategoryServiceImpl categoryService) {
        this.newTextWorker = newTextWorker;
        this.categoryService = categoryService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String seePage(@ModelAttribute TextFormInput textFormInput,
                          Model model) {
        model.addAttribute("textFormData", new TextFormData(categoryService.getAllCategories()));
        return "addText";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addText(@ModelAttribute TextFormInput textFormInput) {
        newTextWorker.add(textFormInput.toBibleTextDtoWithUser());
        return "redirect:overzicht.html?categoryId=" + textFormInput.getCategory();
    }
}
