package com.doranco.projet.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SecurityController {
	
	@GetMapping("/403")
	public String notAuth() {
		return "403";		
	}

}
