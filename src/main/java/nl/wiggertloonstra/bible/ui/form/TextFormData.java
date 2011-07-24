package nl.wiggertloonstra.bible.ui.form;

import java.util.List;

import nl.wiggertloonstra.bible.ui.view.BookView;
import nl.wiggertloonstra.bible.ui.view.CategoryView;

public class TextFormData {
    
    private final List<BookView> books;
    private final List<CategoryView> categories;

    public TextFormData(List<BookView> books, List<CategoryView> categories) {
        this.books = books;
        this.categories = categories;
    }

    public List<BookView> getBooks() {
        return books;
    }
    
    public List<CategoryView> getCategories() {
        return categories;
    }

}
