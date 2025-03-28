package com.qsp.Theatre_management_system.exception;

public class SeatIdNotFound extends RuntimeException{
	
	private String message="seat id not found";

	public String getMessage() {
		return message;
	}

}
