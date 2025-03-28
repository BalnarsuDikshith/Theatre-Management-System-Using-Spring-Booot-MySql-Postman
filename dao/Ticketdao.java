package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Movie;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Payment;
import com.qsp.Theatre_management_system.dto.Screen;
import com.qsp.Theatre_management_system.dto.Ticket;
import com.qsp.Theatre_management_system.repo.TicketRepo;

@Repository
public class Ticketdao {

	@Autowired
	TicketRepo ticketRepo;
	@Autowired
	Paymentdao paymentdao;
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	public Ticket addExistingPaymentToExistingTicket(int paymentId,int ticketId) {
		Payment payment=paymentdao.fetchPaymentById(paymentId);
		Ticket ticket=fetchTicketById(ticketId);
		ticket.setPayment(payment);
		return saveTicket(ticket);
	}
	
	
	
	public Ticket fetchTicketById(int ticketId) {
		Optional<Ticket> dbTicket= ticketRepo.findById(ticketId);
		if(dbTicket.isPresent()) {
			return dbTicket.get();
		}else {
			return null;
		}
	}
	
	public List<Ticket> fetchAllTicket(){
		return ticketRepo.findAll();
	}
	
	public Ticket deleteTicketById(int ticketId) {
		Ticket ticket= ticketRepo.findById(ticketId).get();
	ticketRepo.delete(ticket);
		return ticket;
	}
	
	public Ticket updateTicketById(int oldTicketId, Ticket newTicket) {
		newTicket.setTicketId(oldTicketId);
		return ticketRepo.save(newTicket);
	}
}
