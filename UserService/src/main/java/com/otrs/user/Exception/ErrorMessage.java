package com.otrs.user.Exception;

public class ErrorMessage {

	private int errorCode;
	private Object Message;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public Object getMessage() {
		return Message;
	}
	public void setMessage(Object message) {
		Message = message;
	}
	
	
}
