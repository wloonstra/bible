package nl.wiggertloonstra.bible.hibernate;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.BibleTextDo;
import nl.wiggertloonstra.bible.hibernate.domain.CategoryDo;

public interface CategoryRepository {
    
    List<CategoryDo> getAllCategories();
    List<BibleTextDo> getCategoryFor(int id);

}
