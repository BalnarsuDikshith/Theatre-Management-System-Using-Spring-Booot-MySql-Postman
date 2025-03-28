package com.qsp.Theatre_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Theatre_management_system.dto.Ticket;
import com.qsp.Theatre_management_system.service.TicketService;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/saveTicket")
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}
	
	@PutMapping("/addExistingPaymentToExistingTicket")
	public Ticket addExistingPaymentToExistingTicket(@RequestParam int paymentId,@RequestParam int ticketId) {
		return ticketService.addExistingPaymentToExistingTicket(paymentId, ticketId);
	}
	
	@GetMapping("/fetchTicketById")
	public ResponseStructure<Ticket> fetchTicketById(@RequestParam int ticketId) {
		return ticketService.fetchTicketById(ticketId);
	}
	
	@GetMapping("/fetchAllTicket")
	public ResponseStructureList<Ticket> fetchAllTicket(){
		return ticketService.fetchAllTicket();
	}
	
	@DeleteMapping("/deleteTicketById")
	public ResponseStructure<Ticket> deleteTicketById(@RequestParam int ticketId) {
	return ticketService.deleteTicketById(ticketId);
	}
	
	@PutMapping("/updateTicketById")
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTicketId,@RequestBody Ticket newTicket) {
		return ticketService.updateTicketById(oldTicketId, newTicket);
	}


}
