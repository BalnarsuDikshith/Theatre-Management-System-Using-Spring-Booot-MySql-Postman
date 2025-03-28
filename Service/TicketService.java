package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Ticketdao;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Payment;
import com.qsp.Theatre_management_system.dto.Ticket;
import com.qsp.Theatre_management_system.exception.TicketIdNotFound;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class TicketService {
	
	@Autowired
	Ticketdao ticketdao;
	@Autowired
	ResponseStructure<Ticket> responseStructure;
	
	@Autowired
	ResponseStructureList<Ticket> responseStructureList;
	
	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Ticket inserted into DB");
		responseStructure.setData(ticketdao.saveTicket(ticket));
		return responseStructure;
	}
	

	public Ticket addExistingPaymentToExistingTicket(int paymentId,int ticketId) {
		return ticketdao.addExistingPaymentToExistingTicket(paymentId, ticketId);
	}
	
	public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
		Ticket ticket=ticketdao.fetchTicketById(ticketId);
		if(ticket!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Ticket Fetched from DB");
		responseStructure.setData(ticketdao.fetchTicketById(ticketId));
		return responseStructure;
		}else {
			throw new TicketIdNotFound();
		}
	}
	
	public ResponseStructureList<Ticket> fetchAllTicket(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Tickets Fetched from DB");
		responseStructureList.setData(ticketdao.fetchAllTicket());
		return responseStructureList;
	}
	
	public ResponseStructure<Ticket> deleteTicketById(int ticketId) {
		Ticket ticket=ticketdao.fetchTicketById(ticketId);
		if(ticket!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket deleted in DB");
		responseStructure.setData(ticketdao.deleteTicketById(ticketId));
	    return responseStructure;
		}else {
			throw new TicketIdNotFound();
		}
	}
	
	public ResponseStructure<Ticket> updateTicketById(int oldTicketId, Ticket newTicket) {
		Ticket ticket=ticketdao.fetchTicketById(oldTicketId);
		if(ticket!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket Updated into DB");
		responseStructure.setData(ticketdao.updateTicketById(oldTicketId, newTicket));
		return responseStructure;
		}else {
			throw new TicketIdNotFound();
		}
	}

}
