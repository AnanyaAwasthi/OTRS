package com.otrs.user.Utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="BookingService",url="localhost:8082/booking")
public interface UserBookFeign {
	
@PostMapping("/AddBookings")
public ResponseEntity<?> MakeABooking(@RequestBody Object obj);
}
