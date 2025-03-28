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

import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.service.OwnerService;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	@PostMapping("/saveOwner")
//	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
//	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
//			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })


	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	@PutMapping("/addExistingTheatreToExistingOwner")
	public Owner addExistingTheatreToExistingOwner(@RequestParam int theatreId,@RequestParam int ownerId) {
		return ownerService.addExistingTheatreToExistingOwner(theatreId, ownerId);
	}
	
	@GetMapping("/fetchOwnerById")
	public ResponseStructure<Owner> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}
	
	@GetMapping("/fetchAllOwner")
	public ResponseStructureList<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
		
	}
	
	@DeleteMapping("/deleteOwnerById")
	public ResponseStructure<Owner> deleteOwnerById(@RequestParam int ownerId) {
		
	    return ownerService.deleteOwnerById(ownerId);
	    
	}
	
	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int oldOwnerId, @RequestBody Owner newOwner)
	{
		return ownerService.updateOwnerById(oldOwnerId,newOwner);
	}

}
