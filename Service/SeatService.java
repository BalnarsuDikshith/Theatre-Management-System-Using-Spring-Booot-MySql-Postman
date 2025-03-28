package com.qsp.Theatre_management_system.service;

import java.net.ResponseCache;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Seatdao;
import com.qsp.Theatre_management_system.dto.Seat;
import com.qsp.Theatre_management_system.dto.Seat;
import com.qsp.Theatre_management_system.dto.Viewer;
import com.qsp.Theatre_management_system.exception.SeatIdNotFound;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class SeatService {

	@Autowired
	Seatdao seatdao;
	
	@Autowired
	ResponseStructure<Seat> responseStructure;
	@Autowired
	ResponseStructureList<Seat> responseStructureList;
	
	public ResponseStructure<Seat> saveSeat(Seat seat) {
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Seat inserted into DB");
		responseStructure.setData(seatdao.saveSeat(seat));
		return responseStructure;
	}
	

	public Seat addExistingViewerToExistingSeat(int viewerId,int seatId) {
		return seatdao.addExistingViewerToExistingSeat(viewerId, seatId);
	}
	
	public ResponseStructure<Seat> fetchSeatById(int seatId) {
		Seat seat=seatdao.fetchSeatById(seatId);
		if(seat!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Seat fetched from DB");
		responseStructure.setData(seatdao.fetchSeatById(seatId));
		return responseStructure;
		}else {
			throw new SeatIdNotFound();
		}
	}
	
	public  ResponseStructureList<Seat> fetchAllSeat() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Seats Fetched from DB");
		responseStructureList.setData(seatdao.fetchAllSeat());
		return responseStructureList;
	}
	
	public ResponseStructure<Seat> deleteSeatById(int seatId) {
		Seat seat=seatdao.fetchSeatById(seatId);
		if(seat!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Seat deleted in DB");
		responseStructure.setData(seatdao.deleteSeatById(seatId));
	    return responseStructure;
		}else {
			throw new SeatIdNotFound();
		}
	    
	}
	
	public ResponseStructure<Seat> updateSeatById(int oldSeatId,Seat newSeat)
	{
		Seat seat=seatdao.fetchSeatById(oldSeatId);
		if(seat!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Seat Updated into DB");
		responseStructure.setData(seatdao.updateSeatById(oldSeatId,newSeat));
		return responseStructure;
		}else {
			throw new SeatIdNotFound();
		}
	}
}
