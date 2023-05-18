package com.otrs.restaurant.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.otrs.restaurant.Entity.RestaurantEntity;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Long>{
	
	@Query("select rs from RestaurantEntity rs where rs.rRname = :rRname")
	Optional<List<RestaurantEntity>> findByName(String rRname);
	
	@Query("select rs from RestaurantEntity rs where rs.rRaddress = :rRaddress")
	Optional<List<RestaurantEntity>> findByAddress(String rRaddress);
	
	@Query("select rs from RestaurantEntity rs where rs.rRaddress = :rRaddress")
	List<RestaurantEntity> findByAddress1(String rRaddress);
	
	
}
