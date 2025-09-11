package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.dto.LoginRequest;
import com.tka.entity.User;
import com.tka.service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService service;

	@PostMapping("/login")
	public String loginUser(@ModelAttribute LoginRequest loginRequest, Model model) {

		User user = service.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
		
		

		if (user != null) {
			// get all user
			List<User> list = service.allUser();
			
			for (User users : list) {
				System.out.println(users);
			}
			
			model.addAttribute("users", list);
			return "home";
		} else {

			model.addAttribute("msg", "Invalid Credientials");
			return "login";
		}

	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user,Model model) {

		int status = service.registerUser(user);
		model.addAttribute("status", status);

		return "register";

	}

}
