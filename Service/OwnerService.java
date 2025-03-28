package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Ownerdao;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.exception.OwnerIdNotFound;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;
@Service
public class OwnerService {
	
	@Autowired
	Ownerdao ownerdao;
	@Autowired
	ResponseStructure<Owner> responseStructure;
	
	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	
	public ResponseStructure<Owner> saveOwner(Owner owner) {
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Owner inserted into DB");
		responseStructure.setData(ownerdao.saveOwner(owner));
		return responseStructure;
	}
	
	public Owner addExistingTheatreToExistingOwner(int theatreId, int ownerId) {
		return ownerdao.addExistingTheatreToExistingOwner(theatreId, ownerId);
	}
	
	public ResponseStructure<Owner> fetchOwnerById(int ownerId) {
		Owner owner=ownerdao.fetchOwnerById(ownerId);
		if(owner!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Owner fetched from DB");
		responseStructure.setData(ownerdao.fetchOwnerById(ownerId));
		return responseStructure;
		}else {
			throw new OwnerIdNotFound();
		}
	}
	
	public ResponseStructureList<Owner> fetchAllOwner() {
		
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Owners Fetched from DB");
		responseStructureList.setData(ownerdao.fetchAllOwner());
		return responseStructureList;
		
	}
	
	public ResponseStructure<Owner> deleteOwnerById(int ownerId) {
		Owner owner=ownerdao.fetchOwnerById(ownerId);
		if(owner!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Owner deleted in DB");
		responseStructure.setData(ownerdao.deleteOwnerById(ownerId));
	    return responseStructure;
		}else {
			throw new OwnerIdNotFound();
		}
	    
	}
		
	public ResponseStructure<Owner> updateOwnerById(int oldOwnerId,Owner newOwner)
	{
		Owner owner=ownerdao.fetchOwnerById(oldOwnerId);
		if(owner!=null) {

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Owner Updated into DB");
		responseStructure.setData(ownerdao.updateOwnerById(oldOwnerId,newOwner));
		return responseStructure;
		}else {
			throw new OwnerIdNotFound();
		}
		
	}


}
