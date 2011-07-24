package nl.wiggertloonstra.bible.ui.view;

import nl.wiggertloonstra.bible.contants.Urls;
import nl.wiggertloonstra.bible.hibernate.domain.CategoryDo;

public class CategoryView {
    
    private static final Urls URLS = Urls.INSTANCE;
    
    private final CategoryDo categoryDo;

    private final int numberOfTexts;

    public CategoryView(CategoryDo categoryDo, int numberOfTexts) {
        this.categoryDo = categoryDo;
        this.numberOfTexts = numberOfTexts;
    }
    
    public String getName() {
        return categoryDo.getName();
    }
    
    public String getUrl() {
        return URLS.overview() + "?categoryId=" + categoryDo.getId();
    }
    
    public int getId() {
        return categoryDo.getId();
    }
    
    public int getNumberOfTexts() {
        return numberOfTexts;
    }
}
