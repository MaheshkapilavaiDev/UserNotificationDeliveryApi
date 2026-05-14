package com.usernotificationpreferencedeliveryapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.usernotificationpreferencedeliveryapi.entity.User;
import com.usernotificationpreferencedeliveryapi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public User createUser(@Valid @RequestBody User user) {

		return userService.createUser(user);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {

		return userService.getUser(id);
	}

	@GetMapping
	public List<User> getAllUsers() {

		return userService.getAllUsers();
	}
}
