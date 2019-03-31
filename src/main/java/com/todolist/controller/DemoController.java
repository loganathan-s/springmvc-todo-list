package com.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	// Ve dont need to enter the web-inf or whatever the file path path
	// of the view file since view resolver will do that for us
	// http://localhost:8080/todo-list/welcome
	@GetMapping("welcome")
	public String welcome(Model model) {
		model.addAttribute("user", "Logan");
		log.info("model={}", model);
		//Name of the JSP file
		return "welcome";
	}

	// Executed before request methods
	@ModelAttribute("welcomeMessage")
	public String welcomMessage() {
		log.info("welcomeMessage() called");
		return "Welcome to this demo application";

	}
}
