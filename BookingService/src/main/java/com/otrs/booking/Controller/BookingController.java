package com.otrs.booking.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otrs.booking.Entity.BookingEntity;
import com.otrs.booking.Service.BookingService;
import com.otrs.booking.Utils.BookingToRestFeign;
import com.otrs.booking.Utils.BookingToUserFeign;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingservice;
	
	@Autowired
	private BookingToRestFeign bookingToRestFeign;
	
	@Autowired
	private BookingToUserFeign bookingToUserFeign;
	
	@GetMapping("/getAllBookings")
	public ResponseEntity<List<BookingEntity>> getAllBookings() throws Exception
	{
		return bookingservice.getAllBookings();
	}

	@PostMapping("/AddBookings")
	public ResponseEntity<List<BookingEntity>> addBookings(@RequestBody BookingEntity bookingEntity)throws Exception
	{
		return bookingservice.addBookings(bookingEntity);
	}
	
	@GetMapping("/getAllDetailsById")
	public Map<String,Object> getAllDetailsById(@RequestParam("id") long Bid) throws Exception
	{
		BookingEntity booking = bookingservice.getByID(Bid);
		ResponseEntity<?> RestaurantById = bookingToRestFeign.GetRestaurantById(booking.getRid());
		ResponseEntity<?> UserById = bookingToUserFeign.GetUserById(booking.getUid());
		Map<String,Object> AllData = new HashMap<>();
		//Object ls=RestaurantById.getBody();
		AllData.put("Booking ID", Bid);
		AllData.put("User", UserById.getBody());
		AllData.put("Restaurant", RestaurantById.getBody());
		AllData.put("Date", booking.getDate());
		AllData.put("Time", booking.getTime());
		
	
 		return AllData;
		
	}
}
