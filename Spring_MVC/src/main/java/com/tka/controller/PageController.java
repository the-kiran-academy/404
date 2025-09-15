package com.tka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String loginPage() {
		return "login";
	}
	
	
	@GetMapping("/register-page")
	public String registerPage() {
		return "register";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

}
