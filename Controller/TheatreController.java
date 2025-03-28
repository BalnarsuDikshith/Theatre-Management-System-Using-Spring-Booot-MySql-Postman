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

import com.qsp.Theatre_management_system.dto.Branch;
import com.qsp.Theatre_management_system.dto.Theatre;
import com.qsp.Theatre_management_system.service.TheatreService;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@RestController
public class TheatreController {
	
	@Autowired
	TheatreService theatreService;
	@PostMapping("/saveTheatre")
	public ResponseStructure<Theatre> saveTheatre(@RequestBody Theatre theatre) {
		return theatreService.saveTheatre(theatre);
	}
	
	@PutMapping("/addExistingBranchToExistingTheatre")
	public Theatre addExistingBranchToExistingTheatre(@RequestParam int branchId,@RequestParam int theatreId) {
		return theatreService.addExistingBranchToExistingTheatre(branchId, theatreId);
	}
	
	@PutMapping("/addNewBranchToExistingTheatre")
	public Theatre addNewBranchToExistingTheatre(@RequestParam int theatreId,@RequestBody Branch newBranch) {
		return theatreService.addNewBranchToExistingTheatre(theatreId, newBranch);
	}
	
	
	@GetMapping("/fetchTheatreById")
	public ResponseStructure<Theatre> fetchTheatreById(@RequestParam int theatreId) {
		return theatreService.fetchTheatreById(theatreId);
	}
	
	@GetMapping("/fetchAllTheatre")
	public ResponseStructureList<Theatre> fetchAllTheatre() {
		return theatreService.fetchAllTheatre();
	}
	
	@DeleteMapping("/deleteTheatreById")
	public  ResponseStructure<Theatre> deleteTheatreById(@RequestParam int theatreId) {
		
		return theatreService.deleteTheatreById(theatreId);
		
	}
	
	@PutMapping("/updateTheatreById")
	public ResponseStructure<Theatre> updateTheatreById(@RequestParam int oldTheatreId, @RequestBody Theatre newTheatre) {
		
		return theatreService.saveTheatre(newTheatre);
		
	}

}
