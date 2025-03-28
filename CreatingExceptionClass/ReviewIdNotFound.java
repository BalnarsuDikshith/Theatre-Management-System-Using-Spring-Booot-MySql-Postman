package com.qsp.Theatre_management_system.exception;

public class ReviewIdNotFound extends RuntimeException{
	
	private String message="review id not found";

	public String getMessage() {
		return message;
	}

}
