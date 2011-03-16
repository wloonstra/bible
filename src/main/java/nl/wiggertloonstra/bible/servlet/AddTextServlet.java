package nl.wiggertloonstra.bible.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.wiggertloonstra.bible.collaborator.NewTextWorker;
import nl.wiggertloonstra.bible.dto.BibleTextDto;

/**
 * Servlet to add a new BibleText to the system.
 * @author wloonstra
 */
public class AddTextServlet extends HttpServlet {

    private static final long serialVersionUID = 1543664454861739482L;
    private static final NewTextWorker newTextWorker = new NewTextWorker();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("jsp/addText.jsp");
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BibleTextDto newBibleText = createBibleTextDtoFrom(request);
        newTextWorker.add(newBibleText);
        
        response.sendRedirect("overzicht");
    }

    private BibleTextDto createBibleTextDtoFrom(HttpServletRequest request) {
        BibleTextDto bibleTextDto = new BibleTextDto();
        bibleTextDto.bookName = request.getParameter("book");
        bibleTextDto.startChapter = request.getParameter("startChapter");
        bibleTextDto.startVerse = request.getParameter("startVerse");
        bibleTextDto.endChapter = request.getParameter("endChapter");
        bibleTextDto.endVerse = request.getParameter("endVerse");
        bibleTextDto.motivation = request.getParameter("motivation");
        return bibleTextDto;
    }

}
