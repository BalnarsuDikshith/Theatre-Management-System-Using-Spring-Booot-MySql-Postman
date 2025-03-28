package com.qsp.Theatre_management_system.exception;

public class PaymentIdNotFound extends RuntimeException{
	
	private String message="payment id not found";

	public String getMessage() {
		return message;
	}

}
