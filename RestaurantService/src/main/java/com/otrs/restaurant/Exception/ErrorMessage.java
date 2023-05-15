package com.otrs.restaurant.Exception;

public class ErrorMessage {

	
	private int errorcode;
	private Object message;
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object object) {
		this.message = object;
	}

}
