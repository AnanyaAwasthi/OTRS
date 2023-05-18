package com.otrs.booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otrs.booking.Entity.BookingEntity;
import com.otrs.booking.Service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingservice;
	
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
}
