package nl.wiggertloonstra.bible.ui.form;

import java.util.List;

import nl.wiggertloonstra.bible.ui.view.CategoryView;

public class TextFormData {
    
    private final List<CategoryView> categories;

    public TextFormData(List<CategoryView> categories) {
        this.categories = categories;
    }
    
    public List<CategoryView> getCategories() {
        return categories;
    }

}
