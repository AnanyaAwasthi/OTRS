package com.otrs.user.Utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="RestaurantService",url="localhost:8080")
public interface UserRestFeign {

	
	@GetMapping("/restaurant")
	ResponseEntity<?> GetFeignRestaurant();
	
	@GetMapping("/restaurant/getDetailsByAddress")
	ResponseEntity<?> GetFeignRestaurantByAddress
	(@RequestParam ("address") String address);
	
}
