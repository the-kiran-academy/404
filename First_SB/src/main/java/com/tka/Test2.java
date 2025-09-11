package com.tka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2 {
	
	@GetMapping("/multi")
	public double multi() {
		return 4*5;
	}

}
