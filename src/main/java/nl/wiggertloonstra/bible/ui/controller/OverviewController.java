package nl.wiggertloonstra.bible.ui.controller;

import java.io.IOException;
import java.util.List;

import nl.wiggertloonstra.bible.hibernate.BibleRepository;
import nl.wiggertloonstra.bible.service.CategoryServiceImpl;
import nl.wiggertloonstra.bible.ui.view.BibleTextView;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OverviewController {
    
    private final BibleRepository bibleRepository;
    private final CategoryServiceImpl categoryService;

    @Autowired
    public OverviewController(BibleRepository bibleRepository,
                              CategoryServiceImpl categoryService) {
        this.bibleRepository = bibleRepository;
        this.categoryService = categoryService;
    }
    
    @RequestMapping("/overzicht.html")
    public String overview(Model model,
                           @RequestParam(required = false, defaultValue = "0") int categoryId) throws ClientProtocolException, IOException {
        model.addAttribute("categoriesHeader", getHeaderFor(categoryId));
        model.addAttribute("bibleTexts", getBibleTextsFor(categoryId));
        return "overview";
    }

    private String getHeaderFor(int categoryId) {
        if (categoryId > 0) {
            return categoryService.getCategoryViewFor(categoryId).getName();
        } else {
            return "Alle categorieen";
        }
    }
    
    private List<BibleTextView> getBibleTextsFor(int categoryId) {
        if (categoryId > 0) {
            return bibleRepository.getBibleTextsForCategory(categoryId);
        } else {
            return bibleRepository.getLatestBibleTexts(10);
        }
    }




}
