package com.jobPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.model.User;
import com.jobPortal.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/test")
	public String test() {
		System.out.println("It Worked");
		return "It Works";
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		userService.register(user);
		return ResponseEntity.ok("User Registerd Successfully");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user){
		User existing = userService.login(user.getEmail(), user.getPassword());
		if(existing != null) {
			return ResponseEntity.ok("Login Successfull");
		}else {
			return ResponseEntity.status(401).body("Invalid Creds");
		}
	}
	
	@GetMapping("/getUser/{email}")
	public ResponseEntity<String> getUser(@PathVariable String email){
		User fetchUser = userService.fetchUser(email);
		if(fetchUser != null) {
			System.out.println("User Details fetched Successfull");
			System.out.println(fetchUser);
			userService.addLoginDetails(fetchUser);
			return ResponseEntity.ok("User Details fetch Successfull and log added in table LOGIN_LOG");
		}else {
			System.out.println("Email ID does not exists");
			return ResponseEntity.status(401).body("Email ID does not exists");
		}
		
	}
	
}
