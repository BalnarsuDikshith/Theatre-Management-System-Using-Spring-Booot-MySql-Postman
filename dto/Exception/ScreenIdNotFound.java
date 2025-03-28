package com.qsp.Theatre_management_system.exception;

public class ScreenIdNotFound extends RuntimeException{
	
	private String message="screen id not found";

	public String getMessage() {
		return message;
	}

}
