package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.CategoryDo;

public interface CategoryRepository {
    
    List<CategoryDo> getAllCategories();
    CategoryDo getCategoryFor(int id);
    
}
