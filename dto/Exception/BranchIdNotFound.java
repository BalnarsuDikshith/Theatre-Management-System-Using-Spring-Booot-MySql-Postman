package com.qsp.Theatre_management_system.exception;

public class BranchIdNotFound extends RuntimeException{
	
	private String message="branch id not found";

	public String getMessage() {
		return message;
	}

}
