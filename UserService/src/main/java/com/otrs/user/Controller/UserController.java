package com.otrs.user.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otrs.user.Entity.UserEntity;
import com.otrs.user.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserEntity>> getAllUsers() throws Exception
	{
		return userService.getAllUsers();
	}
	@PostMapping("/addNewUser")
	public ResponseEntity<?> addNewUser(@Valid @RequestBody UserEntity user1) throws Exception
	{
		return userService.addNewUser(user1);
	}

}
