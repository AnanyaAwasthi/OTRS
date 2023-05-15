package com.otrs.restaurant.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tables")
public class TableEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tId=1;
	@Min(value=1,message = "Enter the capacity of the table")
	private int tCapacity;
	@NotNull(message="Status of the table is unknown")
	private boolean isOccupied;
	
	
	public long gettId() {
		return tId;
	}


	public void settId(long tId) {
		this.tId = tId;
	}


	public int gettCapacity() {
		return tCapacity;
	}


	public void settCapacity(int tCapacity) {
		this.tCapacity = tCapacity;
	}


	public boolean isOccupied() {
		return isOccupied;
	}


	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	

	public TableEntity(long tId, int tCapacity, boolean isOccupied) {
		super();
		this.tId = tId;
		this.tCapacity = tCapacity;
		this.isOccupied = isOccupied;
	}


	public TableEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
