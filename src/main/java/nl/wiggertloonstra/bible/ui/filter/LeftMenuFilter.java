package nl.wiggertloonstra.bible.ui.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import nl.wiggertloonstra.bible.service.CategoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component("left-menu")
public class LeftMenuFilter extends GenericFilterBean {

    private final CategoryServiceImpl categoryService;

    @Autowired
    public LeftMenuFilter(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        request.setAttribute("categories", categoryService.getAllCategories());
        
        chain.doFilter(request, response);
    }

}
