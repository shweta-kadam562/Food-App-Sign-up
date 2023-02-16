package com.foodapp.rest.r.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.rest.r.model.User;
import com.foodapp.rest.r.repo.UserRepo;

@RestController
//@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/sign-up")
	public ResponseEntity<String> signUp(@RequestBody User user) {

		User userDB = userRepo.getUserByUsername(user.getUsername());
		if (!(userDB == null)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already present");
		}

		String encodedPassword = passwordEncoder.encode(user.getPassword());
		// attach encoded password to user
		user.setPassword(encodedPassword);
		userRepo.save(user);
		return ResponseEntity.status(HttpStatus.OK).body("Signup Success");

	}

	@GetMapping("/login")
	public User login(Principal principal) { 
		User user = userRepo.getUserByUsername(principal.getName());
		return user;
	}

	@GetMapping("/hello")
	public String getHello() {
		return "Hello";
	}

	@GetMapping("/private/hello")
	public String getAuthHello() {
		return "Auth Hello";
	}

	@GetMapping("private/role/hello")
	public String getPrivateRoleHello() {
		return "Private Role Hello";
	}
}