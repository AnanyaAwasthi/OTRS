package com.otrs.restaurant;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.otrs.restaurant.Entity.RestaurantEntity;
import com.otrs.restaurant.Entity.TableEntity;
import com.otrs.restaurant.Repository.RestaurantRepository;
import com.otrs.restaurant.Repository.TableRepository;

@SpringBootApplication
public class RestaurantServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApplication.class, args);
	}
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
    public void run(String...args) throws Exception {
		
		
		 Environment environment;

		
		try {
			
			
			/*
			 * RestaurantEntity apnaDhaba = new RestaurantEntity("Apna Dhaba", "Faridabad"
			 * );
			 * 
			 * TableEntity tb = new TableEntity(1,2,true); TableEntity tb1 = new
			 * TableEntity(2,4,true);
			 * 
			 * apnaDhaba.getTableDetails().add(tb); apnaDhaba.getTableDetails().add(tb1);
			 * 
			 * this.restaurantRepository.save(apnaDhaba);
			 * 
			 * RestaurantEntity Sagar = new RestaurantEntity("Sagar Ratna", "Chandigarh" );
			 * 
			 * TableEntity tb2 = new TableEntity(3,9,false); TableEntity tb3 = new
			 * TableEntity(4,3,true);
			 * 
			 * 
			 * Sagar.getTableDetails().add(tb2); Sagar.getTableDetails().add(tb3);
			 * 
			 * this.restaurantRepository.save(Sagar);
			 */
			 
			 
		}
	
		catch(Exception ex){
			
		}
		
		
	}

}
