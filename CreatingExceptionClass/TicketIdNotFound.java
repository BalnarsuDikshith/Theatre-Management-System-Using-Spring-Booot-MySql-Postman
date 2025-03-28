package com.qsp.Theatre_management_system.exception;

public class TicketIdNotFound extends RuntimeException{
	
	private String message="ticket id not found";

	public String getMessage() {
		return message;
	}

}
