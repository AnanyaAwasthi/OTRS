package com.otrs.booking.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorMessage> GeneralExceptionHandler(Exception ex)
	{
		ErrorMessage er= new ErrorMessage();
		er.setErrorCode(HttpStatus.NOT_FOUND.value());
		er.setMessage(ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}

}
