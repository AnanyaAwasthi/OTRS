package com.otrs.user.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otrs.user.Entity.UserEntity;
import com.otrs.user.Service.UserService;
import com.otrs.user.Utils.UserRestFeign;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRestFeign userRestFeign;
	
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
	
	@GetMapping("/getById")
	public ResponseEntity<UserEntity>getById(@RequestParam("id") long Id)throws Exception
	{
		return userService.getById(Id);
	}
	//TEST USING RESTTEMPLATE
	@GetMapping("/GetRestaurantDetails")
	public ResponseEntity<?> GetRestaurantDetails(@RequestParam ("id") long Uid, @RequestParam("capacity") int capacity) throws Exception
	{
		return userService.GetRestaurantDetails(Uid,capacity);
	}
	
	// TEST USING FEIGN CLIENT
	@GetMapping("/GetFeignRestaurant")
	public ResponseEntity<?> GetFeignRestaurantCall()
	{
		return userRestFeign.GetFeignRestaurant();	
	}
	
	//TEST USING FEIGN CLIENT FOR REQUEST PARAM
	@GetMapping("/GetFeignRestaurantByAddress")
	public ResponseEntity<?> GetFeignRestaurantByAddress(@RequestParam("address") String address)
	{
		return userRestFeign.GetFeignRestaurantByAddress(address);
	}

}
