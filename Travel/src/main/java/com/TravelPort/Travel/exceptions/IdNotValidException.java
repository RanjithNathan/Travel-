package com.TravelPort.Travel.exceptions;

public class IdNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdNotValidException(String message) {
		super(message);
	}

}
