package com.softgraf.primavera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		request.setAttribute("nome", "Lucas Felipe");
		
		return "bemvindo";
	}
	
	@GetMapping("/hello2")
	public String hello2(Model model) {
		model.addAttribute("nome", "Lucas Felipe");
		
		return "bemvindo";
	}

}
