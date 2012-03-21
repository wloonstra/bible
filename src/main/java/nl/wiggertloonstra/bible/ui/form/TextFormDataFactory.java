package nl.wiggertloonstra.bible.ui.form;

import nl.wiggertloonstra.bible.hibernate.BibleRepository;
import nl.wiggertloonstra.bible.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextFormDataFactory {

    private BibleRepository bibleRepository;
    private final CategoryService categoryService;
    
    @Autowired
    public TextFormDataFactory(BibleRepository bibleRepository,
                               CategoryService categoryService) {
        this.bibleRepository = bibleRepository;
        this.categoryService = categoryService;
    }
    
    public TextFormData newTextFormData() {
        return new TextFormData(bibleRepository.getBooks(),
                                categoryService.getAllCategories());
    }
}
