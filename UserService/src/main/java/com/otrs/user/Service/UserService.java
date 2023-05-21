package com.otrs.user.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.otrs.user.Entity.UserEntity;
import com.otrs.user.Exception.RestTemplateErrorHandler;
import com.otrs.user.Repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RestTemplate restTemplate;
	
	public ResponseEntity<List<UserEntity>> getAllUsers() throws Exception
	{
		if(userRepository.findAll().isEmpty())
		{
			throw new Exception("No user found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
	}
	
	public ResponseEntity<?> addNewUser( UserEntity user1) throws Exception
	{
		List<UserEntity> user = userRepository.findByName(user1.getName());
		if(user.isEmpty())
		{
			userRepository.save(user1);
		}
		if(user.size()>0) 
		{ throw new Exception("User already present"); } 
		
		/*
		 * else if(user1.getMobile().equals(user.)) { throw new Exception("User with "+
		 * user1.getMobile() +" already present"); }
		 */

		
		return getAllUsers();
	}
	
	public ResponseEntity<?> GetRestaurantDetails(long Uid,int capacity) throws Exception
	{
		String address = userRepository.findAddressById(Uid);
		
		restTemplate.setErrorHandler(new RestTemplateErrorHandler());
		ResponseEntity<?> res = restTemplate.getForEntity("Http://localhost:8080/restaurant/filterByAddressAndCapacity?Rraddress="+address+"&capacity="+capacity,String.class );
		return res;
	}

	public ResponseEntity<UserEntity> getById(long id) {
		Optional<UserEntity> us = userRepository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(us.get());
	}
}
