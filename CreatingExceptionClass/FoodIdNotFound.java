package com.qsp.Theatre_management_system.exception;

public class FoodIdNotFound extends RuntimeException{
	
	private String message="food id not found";

	public String getMessage() {
		return message;
	}

}
