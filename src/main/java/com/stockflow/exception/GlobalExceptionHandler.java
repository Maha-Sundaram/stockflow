package com.stockflow.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handleResourceNotFound(ResourceNotFoundException ex) {
		
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		
		error.setTimestamp(LocalDateTime.now());
		
		return error;
		
	}
	
	@ExceptionHandler(InsufficientStockException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleStockException(InsufficientStockException ex) {
	
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		
		error.setTimestamp(LocalDateTime.now());
		
	return error;
	
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handelGenericException(Exception ex) {
		
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(ex.getMessage());
		
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		error.setTimestamp(LocalDateTime.now());
		
		return error;
	}
	
}
