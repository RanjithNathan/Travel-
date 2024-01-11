package com.TravelPort.Travel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler
{
	
	
	@ExceptionHandler(AgentAlreadyExitsException.class)
	public ResponseEntity<String> AgentsAlreadyExitsExceptionHandler(AgentAlreadyExitsException ex)
	{
		
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
		
	}
	
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> UserNotFoundException(UserNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	
	
	@ExceptionHandler(IdNotValidException.class)
	public ResponseEntity<String> IdNotValidException(IdNotValidException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(TicketNotAvailableException.class)
	public ResponseEntity<String> TicketsNotAvailableExceptionHandler(TicketNotAvailableException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.EXPECTATION_FAILED);
	}
	
	
}
