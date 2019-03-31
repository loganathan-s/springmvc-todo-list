package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
	public String welcome() {
		//Name of the JSP file
		return "welcome";
	}
}
