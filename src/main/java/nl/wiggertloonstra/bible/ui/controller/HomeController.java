package nl.wiggertloonstra.bible.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final long serialVersionUID = 7803277386849094314L;

	@RequestMapping("/home.html")
	public String home() {
		return "home";
	}

}
