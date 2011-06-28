package nl.wiggertloonstra.bible.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.wiggertloonstra.bible.domain.BibleText;
import nl.wiggertloonstra.bible.hibernate.BibleTextRepository;
import nl.wiggertloonstra.bible.hibernate.factory.BibleTextRepositoryFactory;

public class OverviewServlet extends HttpServlet {

    private static final long serialVersionUID = -3430623088639909860L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showBibleTexts(request, response);
    }
    
    private void showBibleTexts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BibleTextRepository bibleTextRepository = BibleTextRepositoryFactory.bibleTextRepository();
        List<BibleText> latestBibleTexts = bibleTextRepository.getLatestBibleTexts(10);
        request.setAttribute("bibleTexts", latestBibleTexts);
        
        RequestDispatcher view = request.getRequestDispatcher("jsp/overview.jsp");
        view.forward(request, response);
    }
}
