package nl.wiggertloonstra.bible.hibernate;

import java.math.BigInteger;
import java.util.List;

import nl.wiggertloonstra.bible.hibernate.domain.CategoryDo;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateCategoryRepository implements CategoryRepository {

    private final SessionManager sessionManager;

    @Autowired
    public HibernateCategoryRepository(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    
    @Override
    public List<CategoryDo> getAllCategories() {
        Session session = sessionManager.session();
        @SuppressWarnings("unchecked")
        List<CategoryDo> categories = (List<CategoryDo>) session.createCriteria(CategoryDo.class).list();
        return categories;
    }

    @Override
    public CategoryDo getCategoryFor(int id) {
        Session session = sessionManager.session();
        return (CategoryDo) session.get(CategoryDo.class, id);
    }

    @Override
    public int getNumberOfTextsFor(int id) {
        Session session = sessionManager.session();
        return ((BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM bibletext WHERE category_id = :categoryId")
                                .setInteger("categoryId", id)
                                .uniqueResult()).intValue();
    }

}
