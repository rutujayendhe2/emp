package com.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.webapp.dto.UserData;
import com.webapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users", produces = "application/json")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/findAll")
	public List<UserData> findAll() {
		return userService.findAll();
	}

	@PostMapping("/add")
	public UserData create(@Valid @RequestBody UserData userData) {
		return userService.create(userData);
	}

}
