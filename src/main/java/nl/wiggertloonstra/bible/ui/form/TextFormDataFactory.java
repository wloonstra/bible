package nl.wiggertloonstra.bible.ui.form;

import nl.wiggertloonstra.bible.service.BookService;
import nl.wiggertloonstra.bible.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextFormDataFactory {

    private final BookService bookService;
    private final CategoryService categoryService;
    
    @Autowired
    public TextFormDataFactory(BookService bookService,
                               CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }
    
    
    public TextFormData newTextFormData() {
        return new TextFormData(bookService.getBooks(),
                                categoryService.getAllCategories());
    }

}
