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

import com.qsp.Theatre_management_system.dto.Seat;
import com.qsp.Theatre_management_system.service.SeatService;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@RestController
public class SeatController {
	@Autowired
	SeatService seatService;
	
	@PostMapping("/saveSeat")
	public ResponseStructure<Seat> saveSeat(@RequestBody Seat seat) {
		return seatService.saveSeat(seat);
	}
	
	@PutMapping("/addExistingViewerToExistingSeat")
	public Seat addExistingViewerToExistingSeat(@RequestParam int viewerId,@RequestParam int seatId) {
		return seatService.addExistingViewerToExistingSeat(viewerId, seatId);
	}
	
	@GetMapping("/fetchSeatById")
	public ResponseStructure<Seat> fetchSeatById(@RequestParam int seatId) {
		return seatService.fetchSeatById(seatId);
	}
	
	@GetMapping("/fetchAllSeat")
	public  ResponseStructureList<Seat> fetchAllSeat() {
		return seatService.fetchAllSeat();
	}
	
	@DeleteMapping("/deleteSeatById")
	public ResponseStructure<Seat> deleteSeatById(@RequestParam int seatId) {
		return seatService.deleteSeatById(seatId);
	}
	
	@PutMapping("/updateSeatById")
	public ResponseStructure<Seat> updateSeatById(@RequestParam int oldSeatId,@RequestBody Seat newSeat){
		return seatService.updateSeatById(oldSeatId, newSeat);
	}

}
