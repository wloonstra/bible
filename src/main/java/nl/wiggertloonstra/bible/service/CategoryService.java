package nl.wiggertloonstra.bible.service;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.CategoryDo;
import nl.wiggertloonstra.bible.ui.view.CategoryView;

public interface CategoryService {
    
    List<CategoryView> getAllCategories();
    CategoryDo getCategoryDoFor(int id);
    CategoryView getCategoryViewFor(int id);

}
