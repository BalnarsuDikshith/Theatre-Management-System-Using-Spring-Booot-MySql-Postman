package com.qsp.Theatre_management_system.exception;

public class StaffIdNotFound extends RuntimeException{
	
	private String message="staff id not found";

	public String getMessage() {
		return message;
	}

}
