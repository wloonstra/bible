package nl.wiggertloonstra.bible.ui.form;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.Book;
import nl.wiggertloonstra.bible.ui.view.CategoryView;

public class TextFormData {

    private List<Book> books;
    private final List<CategoryView> categories;

    public TextFormData(List<Book> books, List<CategoryView> categories) {
        this.books = books;
        this.categories = categories;
    }

    public List<Book> getBooks() {
        return books;
    }
    
    public List<CategoryView> getCategories() {
        return categories;
    }

}
