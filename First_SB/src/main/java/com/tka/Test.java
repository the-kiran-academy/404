package com.tka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	
	@GetMapping("/first")
	public String getMessage() {
		return "Hello World!";
	}
	
	@GetMapping("/second")
	public String getAnotherMessage() {
		return "Hello Again!";
	}

	@GetMapping("/add")
	public int add() {
		return 5+5;
	}
	
	@GetMapping("/sub")
	public int xyz() {
		return 5-3;
	}
}
