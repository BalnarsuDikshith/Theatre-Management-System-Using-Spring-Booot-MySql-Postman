package com.qsp.Theatre_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Theatre_management_system.dto.Ticket;

public interface TicketRepo extends JpaRepository<Ticket,Integer> {

}
