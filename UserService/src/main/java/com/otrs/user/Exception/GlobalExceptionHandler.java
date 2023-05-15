package com.otrs.user.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorMessage> GeneralExceptionHandler(Exception ex)
	{
		ErrorMessage msg = new ErrorMessage();
		msg.setErrorCode(HttpStatus.BAD_REQUEST.value());
		msg.setMessage(ex.getMessage());
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}

}
