package nl.wiggertloonstra.bible.ui.form;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BookDo;
import nl.wiggertloonstra.bible.ui.view.BookView;
import nl.wiggertloonstra.bible.ui.view.CategoryView;

public class TextFormData {

    private List<BookDo> books;
    private final List<CategoryView> categories;

    public TextFormData(List<BookDo> books, List<CategoryView> categories) {
        this.books = books;
        this.categories = categories;
    }

    public List<BookDo> getBooks() {
        return books;
    }
    
    public List<CategoryView> getCategories() {
        return categories;
    }

}
