package com.otrs.user.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message="Name is required")
	private String name;
	@NotEmpty(message="City is required")
	private String city;
	@Pattern(regexp="\\\\d{10}", message="Phone number should be of 10 digits, it should not start with 0 and it should not contain special characters")
	private String mobile;
	@NotNull(message="DOB cannot be null")
	@Past(message = "DOB cannot be present date")
	private LocalDate DOB;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	
	public UserEntity( String name,String city,String mobile,LocalDate dOB) {
		super();
		this.name = name;
		this.city = city;
		this.mobile = mobile;
		DOB = dOB;
	}
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
