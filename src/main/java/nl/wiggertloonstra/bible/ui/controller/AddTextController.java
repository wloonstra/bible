package nl.wiggertloonstra.bible.ui.controller;

import javax.servlet.http.HttpServletRequest;

import nl.wiggertloonstra.bible.collaborator.NewTextWorker;
import nl.wiggertloonstra.bible.dto.BibleTextDto;
import nl.wiggertloonstra.bible.ui.form.TextForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Servlet to add a new BibleText to the system.
 * @author wloonstra
 */
@Controller
@RequestMapping("/tekst-toevoegen")
public class AddTextController {

    private static final long serialVersionUID = 1543664454861739482L;
    private static final NewTextWorker newTextWorker = new NewTextWorker();
    
    @RequestMapping(method = RequestMethod.GET)
    public String seePage() {
        return "addText";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addText(TextForm textForm) {
        BibleTextDto newBibleText = new BibleTextDto();
        newTextWorker.add(newBibleText);
        
        return ("overzicht");
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
