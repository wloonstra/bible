package nl.wiggertloonstra.bible.ui.controller;

import java.io.IOException;
import java.util.List;

import nl.wiggertloonstra.bible.collaborator.BiblijaScraper;
import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.service.CategoryServiceImpl;
import nl.wiggertloonstra.bible.ui.view.BibleTextView;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Controller
public class OverviewController {

    private static final Function<BibleTextDo, BibleTextView> TO_BIBLETEXT_VIEW_AND = new Function<BibleTextDo, BibleTextView>() {
        @Override
        public BibleTextView apply(BibleTextDo from) {
            return new BibleTextView(from);
        }
    };
    
    private final BibleTextRepository bibleTextRepository;
    private final CategoryServiceImpl categoryService;

    private final BiblijaScraper biblijaScraper;

    @Autowired
    public OverviewController(BibleTextRepository bibleTextRepository,
                              CategoryServiceImpl categoryService,
                              BiblijaScraper seleniumTextRetriever) {
        this.bibleTextRepository = bibleTextRepository;
        this.categoryService = categoryService;
        this.biblijaScraper = seleniumTextRetriever;
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
        List<BibleTextDo> bibleTextDos;
        
        if (categoryId > 0) {
            bibleTextDos = bibleTextRepository.getBibleTextsForCategory(categoryId);
        } else {
            bibleTextDos = bibleTextRepository.getLatestBibleTexts(10);
        }
        
        makeSureTextsAreAvailableFor(bibleTextDos);
        return Lists.transform(bibleTextDos, TO_BIBLETEXT_VIEW_AND);
    }

    private void makeSureTextsAreAvailableFor(List<BibleTextDo> bibleTextDos) {
        for (BibleTextDo bibleTextDo : bibleTextDos) {
            if (StringUtils.isBlank(bibleTextDo.getText())) {
                String text = biblijaScraper.findFor(bibleTextDo);
                bibleTextDo.setText(text);
                bibleTextRepository.store(bibleTextDo);
            }
        }
    }


}
