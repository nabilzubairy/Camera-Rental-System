package com.zubairy.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubairy.crs.dto.LoginRequest;
import com.zubairy.crs.model.User;
import com.zubairy.crs.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
	

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String crs() {
		return "CRS";
		
	}
	
	@PostMapping("register")
	public String registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@PostMapping("login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest login, HttpSession session) {
	    User user = userService.loginUser(login.getEmail(), login.getPassword());

	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
	    }

	    session.setAttribute("user", user);
	    return ResponseEntity.ok(user); // return actual user object
	}

	
	
	@PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logged Out";
    }

    @GetMapping("/check-session")
    public Object checkSession(HttpSession session) {
        return session.getAttribute("user");
    }
    
}
