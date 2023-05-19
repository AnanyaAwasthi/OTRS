package com.otrs.booking.Utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="UserService",url="http://localhost:8081")
public interface BookingToUserFeign {
	
	@GetMapping("/user/getById")
	ResponseEntity<?> GetUserById(@RequestParam("id") long id);
	

}
