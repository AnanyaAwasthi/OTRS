package com.otrs.user.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.otrs.user.Entity.UserEntity;
import com.otrs.user.Repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
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
		Optional<UserEntity> user = userRepository.findByName(user1.getName());
		if(user.isEmpty())
		{
			userRepository.save(user1);
		}
		if(user.isPresent()) 
		{ throw new Exception("User already present"); } 
		
		else if(user1.getMobile().equals(user.get().getMobile()))
		{
			throw new Exception("User with "+ user1.getMobile() +" already present");
		}

		
		
		 
		
			
		
		
		return getAllUsers();
	}
	
}
