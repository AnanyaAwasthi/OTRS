package com.otrs.restaurant.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
@Table(name="restaurant")
//uniqueConstraints = { @UniqueConstraint(columnNames = { "rRname", "rRaddress" }) })
public class RestaurantEntity {
	
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rId=1;
	@NotEmpty(message="Name cannot be Empty/Null")
	private String rRname;
	@NotEmpty(message="Address cannot be Empty/Null")
	private String rRaddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="rid")
	 List<TableEntity> tables  = new ArrayList<>();
	
	public long getrId() {
		return rId;
	}
	public void setrId(long rId) {
		this.rId = rId;
	}
	public String getrRname() {
		return rRname;
	}
	public void setrRname(String rRname) {
		this.rRname = rRname;
	}
	public String getrRaddress() {
		return rRaddress;
	}
	public void setrRaddress(String rRaddress) {
		this.rRaddress = rRaddress;
	}
	public List<TableEntity> getTableDetails() {
		return tables;
	}
	public void setTableDetails(List<TableEntity> tableDetails) {
		this.tables = tableDetails;
	}
	
	
	public RestaurantEntity(String rRname, String rRaddress) {
		super();
		
		this.rRname = rRname;
		this.rRaddress = rRaddress;
	}
	public RestaurantEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	

}
