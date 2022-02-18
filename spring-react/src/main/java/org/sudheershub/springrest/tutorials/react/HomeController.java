package org.sudheershub.springrest.tutorials.react;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping (value = "/")
	public String index() {
		return "index";
	}
}
