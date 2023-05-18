package com.otrs.restaurant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otrs.restaurant.Entity.RestaurantEntity;
import com.otrs.restaurant.Entity.TableEntity;
import com.otrs.restaurant.Service.RestaurantService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/restaurant")
@Validated
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantservice;
	
	//GET ALL DETAILS (RESTAURANT AND TABLE)
	@GetMapping
	public ResponseEntity<List<RestaurantEntity>> getAllDetails() 
			throws Exception
	{
		return restaurantservice.getAllDetails();
	}
	
	//GET RESTAURANT DETAILS BY ADDRESS
	@GetMapping("/getDetailsByAddress")
	public ResponseEntity<List<RestaurantEntity>> getDetailsByAddress
	(@RequestParam("address")String address) throws Exception
	{
		return restaurantservice.getDetailsByAddress(address);
	}
	
	// ADDING DATA TO DB AND RETURN ALL DATA
		@PostMapping("/addRestaurant")
		public ResponseEntity<?> addData(@Valid @RequestBody RestaurantEntity res) 
		throws Exception,MethodArgumentNotValidException,
		ConstraintViolationException
		{
			return restaurantservice.addData(res);
		}
		
	// ADD A TABLE TO AN ALREADY CREATED RESTAURANT
	@PostMapping("/add")
	public ResponseEntity<RestaurantEntity> addtables
	(@Min(value=1,message="Please select a restaurant") @RequestParam("rId") int rstid,
			@Valid @RequestBody TableEntity tableentity) 
					throws Exception,MethodArgumentNotValidException
	{
		
		return restaurantservice.addtables(rstid,tableentity);
	}
	
	//CHANGE STATUS OF TABLE AND RETURN ALL DATA
	@PutMapping("/changeTableStatus")
	public ResponseEntity<?> changeStatusOfTable(@RequestParam("tId") int Tid,
			@RequestParam("isoccupied") boolean isOccupied)
					throws Exception,MethodArgumentNotValidException
	{
		return restaurantservice.changeStatusOfTable(Tid,isOccupied);
	}

	//FILTER BY ADDRESS AND TELL THE TOTAL NUMBER OF COUNT OF VACANT TABLES OF THE ASKED CAPACITY
	@GetMapping("/filterByAddressAndCapacity")
	public ResponseEntity<?> filterByAddressAndCapacity
	(@NotEmpty(message="Please Enter address") @RequestParam("Rraddress")String Address,
			@Min(value= 1,message="Capacity should be greater than 1") @RequestParam("capacity")int capacity)
					throws Exception,MethodArgumentNotValidException
	{
		return restaurantservice.filterByAddressAndCapacity(Address,capacity);
	}
	
	

}
