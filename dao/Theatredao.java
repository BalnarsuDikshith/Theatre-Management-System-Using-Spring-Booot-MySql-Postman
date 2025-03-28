package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Branch;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Theatre;
import com.qsp.Theatre_management_system.repo.TheatreRepo;

@Repository
public class Theatredao {

	@Autowired
	TheatreRepo theatreRepo;
	
	@Autowired
	Branchdao branchdao;
	
	public Theatre saveTheatre(Theatre theatre) {
		return theatreRepo.save(theatre);
	}
	
	
	public Theatre addExistingBranchToExistingTheatre(int branchId,int theatreId) {
		Branch branch=branchdao.fetchBranchById(branchId);
		
		Theatre theatre=fetchTheatreById(theatreId);
		
		List<Branch> list=theatre.getBranches();
		list.add(branch);
		theatre.setBranches(list);
		return saveTheatre(theatre);
		
		
	}
	
	public Theatre addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		
		Theatre theatre=fetchTheatreById(theatreId);
		
		List<Branch> list=theatre.getBranches();
		list.add(newBranch);
		theatre.setBranches(list);
		return saveTheatre(theatre);
		
		
	}
	
	
	
	public Theatre fetchTheatreById(int theatreId) {
		Optional<Theatre> dbTheatre= theatreRepo.findById(theatreId);
		if(dbTheatre.isPresent()) {
			return dbTheatre.get();
		}else {
			return null;
		}
	}
	
	public List<Theatre> fetchAllTheatre() {
		return theatreRepo.findAll();
	}
	
	public  Theatre deleteTheatreById(int theatreId) {
		Theatre theatre= theatreRepo.findById(theatreId).get();
		theatreRepo.delete(theatre);
		return theatre;
	}
	
	public Theatre updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		newTheatre.setTheatreId(oldTheatreId);
		return theatreRepo.save(newTheatre);
		
	}
}
