package nl.wiggertloonstra.bible.ui.view;

import nl.wiggertloonstra.bible.contants.Urls;
import nl.wiggertloonstra.bible.hibernate.domain.CategoryDo;

public class CategoryView {
    
    private static final Urls URLS = Urls.INSTANCE;
    
    private final CategoryDo categoryDo;

    public CategoryView(CategoryDo categoryDo) {
        this.categoryDo = categoryDo;
    }
    
    public String getName() {
        return categoryDo.getName();
    }
    
    public String getUrl() {
        return URLS.overview() + "?categoryId=" + categoryDo.getId();
    }
}
