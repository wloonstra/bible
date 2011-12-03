package nl.wiggertloonstra.bible.ui.form;

import nl.wiggertloonstra.bible.hibernate.BookRepository;
import nl.wiggertloonstra.bible.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextFormDataFactory {

    private BookRepository bookRepository;
    private final CategoryService categoryService;
    
    @Autowired
    public TextFormDataFactory(BookRepository bookRepository,
                               CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }
    
    
    public TextFormData newTextFormData() {
        return new TextFormData(bookRepository.getBooks(),
                                categoryService.getAllCategories());
    }

}
