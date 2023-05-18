package com.otrs.booking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.otrs.booking.Entity.BookingEntity;
import com.otrs.booking.Repository.BookingRepository;

@Service
public class BookingService {

	
	@Autowired
	private BookingRepository bookingrepository;
	
	public ResponseEntity<List<BookingEntity>> getAllBookings() throws Exception
	{
		List<BookingEntity> allBookings = bookingrepository.findAll();
		if(allBookings.isEmpty())
		{
			throw new Exception("No Bookings Made");
		}
		return ResponseEntity.status(HttpStatus.OK).body(allBookings);
	}

	public ResponseEntity<List<BookingEntity>> addBookings(BookingEntity bookingEntity) throws Exception {

		bookingrepository.save(bookingEntity);
		return getAllBookings();
	}
}
