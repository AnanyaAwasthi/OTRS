package com.otrs.user;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.otrs.user.Entity.UserEntity;
import com.otrs.user.Repository.UserRepository;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String...args) throws Exception
	{
		Environment environment;
		
		try {
			/*
			 * LocalDate d1=LocalDate.of(1999, 03, 06); UserEntity user = new UserEntity();
			 * user.setName("Ananya"); user.setCity("Bengaluru");
			 * user.setMobile(9888265471L); user.setDOB(d1); this.userRepository.save(user);
			 */
		}
		catch(Exception ex)
		{
			
		}
		
		
	}

}
