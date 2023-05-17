package com.otrs.booking.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class BookingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Bid;
	private long Rid;
	private long Uid;
	private LocalDate date;
	private LocalTime time;
	public long getBid() {
		return Bid;
	}
	public void setBid(long bid) {
		Bid = bid;
	}
	public long getRid() {
		return Rid;
	}
	public void setRid(long rid) {
		Rid = rid;
	}
	public long getUid() {
		return Uid;
	}
	public void setUid(long uid) {
		Uid = uid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public BookingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingEntity(long bid, LocalDate date, LocalTime time) {
		super();
		Bid = bid;
		this.date = date;
		this.time = time;
	}
	
	

}
