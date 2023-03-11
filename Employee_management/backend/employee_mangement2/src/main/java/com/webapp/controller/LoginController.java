package com.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.webapp.dto.UserData;
import com.webapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authenticate", produces = "application/json")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private UserService userService;
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	@PostMapping("/login")
	public UserData create(@RequestBody UserData userData) {

		List<UserData> list = new ArrayList<>();
		list = userService.findAll();
		for (UserData userData1 : list) {
			if (userData.getEmailAdd().equals(userData1.getEmailAdd())
					&& bcrypt.matches(userData.getPassword(), userData1.getPassword())) {
				System.out.println(userData1);
				return userData1;
			}
		}
		return null;
	}
}