package com.qsp.Theatre_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.Theatre_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@Autowired
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseStructure<String> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Owner id is not found in the DB");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseStructure<String> branchIdNotFound(BranchIdNotFound branchIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Branch id is not found in the DB");
		responseStructure.setData(branchIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> addressIdNotFound(AddressIdNotFound addressIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Address id is not found in the DB");
		responseStructure.setData(addressIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseStructure<String> foodIdNotFound(FoodIdNotFound foodIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Food id is not found in the DB");
		responseStructure.setData(foodIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseStructure<String> managerIdNotFound(ManagerIdNotFound managerIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Manager id is not found in the DB");
		responseStructure.setData(managerIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(MovieIdNotFound.class)
	public ResponseStructure<String> movieIdNotFound(MovieIdNotFound movieIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Movie id is not found in the DB");
		responseStructure.setData(movieIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseStructure<String> paymentIdNotFound(PaymentIdNotFound paymentIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Payment id is not found in the DB");
		responseStructure.setData(paymentIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(ReviewIdNotFound.class)
	public ResponseStructure<String> reviewIdNotFound(ReviewIdNotFound reviewIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Review id is not found in the DB");
		responseStructure.setData(reviewIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler (ScreenIdNotFound.class)
	public ResponseStructure<String> screenIdNotFound(ScreenIdNotFound screenIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Screen id is not found in the DB");
		responseStructure.setData(screenIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(SeatIdNotFound.class)
	public ResponseStructure<String> seatIdNotFound(SeatIdNotFound seatIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Seat id is not found in the DB");
		responseStructure.setData(seatIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(StaffIdNotFound.class)
	public ResponseStructure<String> staffIdNotFound(StaffIdNotFound staffIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Staff id is not found in the DB");
		responseStructure.setData(staffIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(TheatreIdNotFound.class)
	public ResponseStructure<String> theatreIdNotFound(TheatreIdNotFound theatreIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Theatre id is not found in the DB");
		responseStructure.setData(theatreIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(TicketIdNotFound.class)
	public ResponseStructure<String> ticketIdNotFound(TicketIdNotFound ticketIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Ticket id is not found in the DB");
		responseStructure.setData(ticketIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(ViewerIdNotFound.class)
	public ResponseStructure<String> viewerIdNotFound(ViewerIdNotFound viewerIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Viewer id is not found in the DB");
		responseStructure.setData(viewerIdNotFound.getMessage());
		return responseStructure;
	}

}
