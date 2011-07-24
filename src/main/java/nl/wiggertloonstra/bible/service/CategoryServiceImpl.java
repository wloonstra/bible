package nl.wiggertloonstra.bible.service;

import java.util.List;

import nl.wiggertloonstra.bible.hibernate.CategoryRepository;
import nl.wiggertloonstra.bible.hibernate.domain.CategoryDo;
import nl.wiggertloonstra.bible.ui.view.CategoryView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Component
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryRepository categoryRepository;
    private Function<CategoryDo, CategoryView> TO_CATEGORY_VIEW = new Function<CategoryDo, CategoryView>() {
        @Override
        public CategoryView apply(CategoryDo from) {
            int numberOfTexts = categoryRepository.getNumberOfTextsFor(from.getId());
            return new CategoryView(from, numberOfTexts);
        }
    };
    
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    public List<CategoryView> getAllCategories() {
        return Lists.transform(categoryRepository.getAllCategories(), TO_CATEGORY_VIEW);
    }
    
    @Override
    public CategoryDo getCategoryDoFor(int id) {
        return categoryRepository.getCategoryFor(id);
    }
    
    @Override
    public CategoryView getCategoryViewFor(int id) {
        return TO_CATEGORY_VIEW.apply(categoryRepository.getCategoryFor(id));
    }

}
