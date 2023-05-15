package com.otrs.restaurant.Exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorMessage> generalExceptionHandler(Exception ex)
	{
		ErrorMessage msg = new ErrorMessage();
		msg.setErrorcode(HttpStatus.NOT_FOUND.value());
		msg.setMessage(ex.getMessage());
		return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public  ResponseEntity<ErrorMessage> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)
	{
		ErrorMessage msg = new ErrorMessage();
		msg.setErrorcode(HttpStatus.BAD_REQUEST.value());
		msg.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", ")));

		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> constraintViolationExceptionHandler(ConstraintViolationException ex) 
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorcode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
			        		                          .collect(Collectors.joining(", ")));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
