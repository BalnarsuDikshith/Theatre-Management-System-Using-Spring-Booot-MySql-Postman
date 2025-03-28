package com.qsp.Theatre_management_system.exception;

public class MovieIdNotFound extends RuntimeException{
	
	private String message="movie id not found";

	public String getMessage() {
		return message;
	}

}
