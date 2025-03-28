package com.qsp.Theatre_management_system.exception;

public class ManagerIdNotFound extends RuntimeException{
	
	private String message="manager id not found";

	public String getMessage() {
		return message;
	}

}
