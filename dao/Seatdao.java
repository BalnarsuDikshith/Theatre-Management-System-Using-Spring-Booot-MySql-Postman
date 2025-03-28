package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Branch;
import com.qsp.Theatre_management_system.dto.Manager;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Seat;
import com.qsp.Theatre_management_system.dto.Viewer;
import com.qsp.Theatre_management_system.repo.SeatRepo;

@Repository
public class Seatdao {
	
	@Autowired
	SeatRepo seatRepo;
	@Autowired
	Viewerdao viewerdao;
	
	public Seat saveSeat(Seat seat) {
		return seatRepo.save(seat);
	}
	

	public Seat addExistingViewerToExistingSeat(int viewerId,int seatId) {
		Viewer viewer=viewerdao.fetchViewerById(viewerId);
		Seat seat=fetchSeatById(seatId);
		seat.setViewer(viewer);
		return saveSeat(seat);
	}
	
	
	public Seat fetchSeatById(int seatId) {
		Optional<Seat> dbSeat= seatRepo.findById(seatId);
		if(dbSeat.isPresent()) {
			return dbSeat.get();
		}else {
			return null;
		}
	}
	
	public  List<Seat> fetchAllSeat() {
		return seatRepo.findAll();
	}
	
	public Seat deleteSeatById(int seatId) {
		Seat seat=seatRepo.findById(seatId).get();
		seatRepo.delete(seat);
		return seat;
	}
	
	public Seat updateSeatById(int oldSeatId,Seat newSeat){
		newSeat.setSeatId(oldSeatId);
		return seatRepo.save(newSeat);
	}
}
