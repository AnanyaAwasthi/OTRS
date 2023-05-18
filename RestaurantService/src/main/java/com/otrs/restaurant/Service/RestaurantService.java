package com.otrs.restaurant.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.otrs.restaurant.Entity.RestaurantEntity;
import com.otrs.restaurant.Entity.TableEntity;
import com.otrs.restaurant.Repository.RestaurantRepository;
import com.otrs.restaurant.Repository.TableRepository;

@Service
public class RestaurantService {
	
	
	@Autowired
	private RestaurantRepository restaurantrepository;
	
	@Autowired
	private TableRepository tableRepository;
		
	public ResponseEntity<List<RestaurantEntity>> getAllDetails() throws Exception
	{
		if((restaurantrepository.findAll()).isEmpty())
		{
			throw new Exception("No Restaurant Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(restaurantrepository.findAll());
	}

	public ResponseEntity<List<RestaurantEntity>> getDetailsByAddress(String address) 
			throws Exception
	{
		List<RestaurantEntity> rs = restaurantrepository.findByAddress1(address);
		if(rs.isEmpty()) throw new Exception("No Restaurants nearby");
		return ResponseEntity.status(HttpStatus.OK).body(rs);
	}
	
	// IF SAME NAME AND ADDRESS ALREADY PRESENT IN DB THEN ERROR ELSE ADD NEW RECORD IN DB
	public ResponseEntity<?> addData(RestaurantEntity res) throws Exception,MethodArgumentNotValidException
	{
		  Optional<List<RestaurantEntity>> reso = restaurantrepository.findByName(res.getrRname());
	
		  List<RestaurantEntity> rs = reso.get();
			  if(reso.isPresent()) {
					
					  for(int i=0;i<reso.get().size();i++) {
					  if((rs.get(i).getrRaddress()).equals(res.getrRaddress())) { throw new
					  Exception("Restaurant already present"); } }
					 
			 
			  }
			restaurantrepository.save(res);

		  return getAllDetails();
		  }
	
	public ResponseEntity<RestaurantEntity> addtables(int rstId, TableEntity tableEntity) throws Exception,MethodArgumentNotValidException
	{
		long lnd = rstId;
		Optional<RestaurantEntity> rs = restaurantrepository.findById(lnd);
		if(!rs.isPresent())
			{throw new Exception("Restaurant not found");}
		else
		{
			RestaurantEntity rst = rs.get();
			rst.getTableDetails().add(tableEntity);
			restaurantrepository.save(rst);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(rs.get());
		
	}
	
	public ResponseEntity<?> changeStatusOfTable(int Tid,Boolean isOccupied) throws Exception,MethodArgumentNotValidException
	{
		long id= Tid;
		Optional<TableEntity> table = tableRepository.findById(id);
		TableEntity tb = table.get();
		tb.setOccupied(isOccupied);
		tableRepository.save(tb);
		
		return getAllDetails();
	}
	
	public ResponseEntity<?> filterByAddressAndCapacity(String rRaddress,int capacity)throws Exception,MethodArgumentNotValidException
	{
		Optional <List<RestaurantEntity>> res = restaurantrepository.findByAddress(rRaddress);
		List<RestaurantEntity>filterByAddress = res.get();
		
		  if(filterByAddress.isEmpty()) { throw new
		  Exception("No Restaurants found in "+ rRaddress); }
		 
		
		  Map<String,Integer> FinalList = new HashMap<>(); for(int
		  i=0;i<filterByAddress.size();i++) { int count=0;
		  
		  int cap = filterByAddress.get(i).getTableDetails().size(); for(int
		  j=0;j<cap;j++) { int checkCapacity =
		  filterByAddress.get(i).getTableDetails().get(j).gettCapacity(); Boolean
		  checkStatus = filterByAddress.get(i).getTableDetails().get(j).isOccupied();
		  if(checkCapacity == capacity && !checkStatus) { count++; } }
		  FinalList.put(filterByAddress.get(i).getrRname(), count);
		  
		  }
		 
		return ResponseEntity.status(HttpStatus.OK).body(FinalList);
		
	}
	
	
}
