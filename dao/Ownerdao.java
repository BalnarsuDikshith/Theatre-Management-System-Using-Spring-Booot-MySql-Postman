package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Theatre;
import com.qsp.Theatre_management_system.repo.OwnerRepo;

@Repository
public class Ownerdao {
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	Theatredao theatredao;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner addExistingTheatreToExistingOwner(int theatreId, int ownerId) {
		Theatre theatre=theatredao.fetchTheatreById(theatreId);
		Owner owner=fetchOwnerById(ownerId);
		owner.setTheatre(theatre);
		return saveOwner(owner);
	}
	
	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> dbOwner= ownerRepo.findById(ownerId);
		if(dbOwner.isPresent()) {
			return dbOwner.get();
		}else {
			return null;
		}
	}
	
	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
		
	}
	
	public Owner deleteOwnerById(int ownerId) {
		Owner owner=fetchOwnerById(ownerId);
	    ownerRepo.delete(owner);
	    return owner;
	}
		
	public Owner updateOwnerById(int oldOwnerId,Owner newOwner)
	{
		newOwner.setOwnerId(oldOwnerId);
		//return saveOwner(newOwner);
		return ownerRepo.save(newOwner);
	}

}
