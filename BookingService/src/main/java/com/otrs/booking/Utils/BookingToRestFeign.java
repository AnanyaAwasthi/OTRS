package com.otrs.booking.Utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="RestaurantService",url="http://localhost:8080")
public interface BookingToRestFeign {
	
	@GetMapping("/restaurant/getDetailsById")
	ResponseEntity<?> GetRestaurantById(@RequestParam("id") long id);

}
