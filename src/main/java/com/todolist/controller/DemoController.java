package com.todolist.controller;

import com.todolist.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

	// == fields ==
	private final DemoService  demoService;

	// == constructors ==
	// constructor dependency injection by spring
	@Autowired
	public DemoController (DemoService demoService) {
		this.demoService = demoService;
	}

	// == Request Methods ==
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	// We dont need to enter the web-inf or whatever the file path path
	// of the view file since view resolver will do that for us
	// http://localhost:8080/todo-list/welcome
	@GetMapping("welcome")
	public String welcome(Model model) {
		model.addAttribute("helloMessage", demoService.getHelloMessage("Logan"));
		log.info("model={}", model);
		//Name of the JSP file
		return "welcome";
	}

	// == Model Attributes ==

	// Executed before request methods
	// Model attribute name is "welcomeMessage"
	@ModelAttribute("welcomeMessage")
	public String welcomMessage() {
		log.info("welcomeMessage() called");
		String welcomMessage = demoService.getWelcomeMessage();
		return welcomMessage;

	}
}
