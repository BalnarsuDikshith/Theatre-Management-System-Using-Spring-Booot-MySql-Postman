package com.qsp.Theatre_management_system.exception;

public class ViewerIdNotFound extends RuntimeException{
	
	private String message="viewer id not found";

	public String getMessage() {
		return message;
	}

}
