package com.qsp.Theatre_management_system.exception;

public class TheatreIdNotFound extends RuntimeException{
	
	private String message="theatre id not found";

	public String getMessage() {
		return message;
	}

}
