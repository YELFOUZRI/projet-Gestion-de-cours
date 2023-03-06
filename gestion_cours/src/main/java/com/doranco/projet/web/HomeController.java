package com.doranco.projet.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { 
	
	 
	
	@GetMapping(path = "/")
	public String index() {
		return "redirect:/home";
	}
	
	@GetMapping(path = "/home")
	public String home() {
		return "home";
	}
	
	@GetMapping(path = "/contact")
	public String contact() { 
		return "contact";
	}
	

}
