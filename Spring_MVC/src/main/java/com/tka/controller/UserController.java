package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.dto.LoginRequest;
import com.tka.entity.User;
import com.tka.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/login")
	public String loginUser(@ModelAttribute LoginRequest loginRequest, Model model) {

		User user = service.loginUser(loginRequest.getUsername(), loginRequest.getPassword());

		if (user != null) {
			// get all user
			List<User> list = service.allUser();

			model.addAttribute("users", list);
			return "home";
		} else {

			model.addAttribute("msg", "Invalid Credientials");
			return "login";
		}

	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user, Model model) {

		int status = service.registerUser(user);
		model.addAttribute("status", status);

		return "register";

	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id, Model model) {
		boolean isDeleted = service.deleteUser(id);
		if (isDeleted) {
			List<User> list = service.allUser();
			model.addAttribute("users", list);
		} else {
			model.addAttribute("msg", "Something Went Wrong During Delete !!");
		}
		return "home";
	}

	@GetMapping("/show")
	public String getUser(@RequestParam int id, Model model) {

		User user = service.getUser(id);
		model.addAttribute("user", user);
		return "profile";

	}

	@PostMapping("/update")
	public String updateProfile(@ModelAttribute User user, Model model) {
		boolean isUpdated = service.updateProfile(user);
		if (isUpdated) {
			List<User> list = service.allUser();
			model.addAttribute("users", list);
			model.addAttribute("msg", "Profile Updated !!");
			return "home";
		} else {
			
			model.addAttribute("user",user);
			return "profile";
		}

	}

}
