package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Theatredao;
import com.qsp.Theatre_management_system.dto.Branch;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Theatre;
import com.qsp.Theatre_management_system.exception.TheatreIdNotFound;
import com.qsp.Theatre_management_system.repo.TheatreRepo;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class TheatreService {
	@Autowired
	Theatredao theatredao;@Autowired
	ResponseStructure<Theatre> responseStructure;
	
	@Autowired
	ResponseStructureList<Theatre> responseStructureList;
	
	public ResponseStructure<Theatre> saveTheatre(Theatre theatre) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Theatre inserted into DB");
		responseStructure.setData(theatredao.saveTheatre(theatre));
		return responseStructure;
		
	}
	
	public Theatre addExistingBranchToExistingTheatre(int branchId,int theatreId) {
		return theatredao.addExistingBranchToExistingTheatre(branchId, theatreId);
	}
	
	
	public Theatre addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		return theatredao.addNewBranchToExistingTheatre(theatreId, newBranch);
	}
	
	public ResponseStructure<Theatre> fetchTheatreById(int theatreId) {
		Theatre theatre=theatredao.fetchTheatreById(theatreId);
		if(theatre!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully theatre fetched from DB");
		responseStructure.setData(theatredao.fetchTheatreById(theatreId));
		return responseStructure;
		}else {
			throw new TheatreIdNotFound();
		}
		}
	
	public ResponseStructureList<Theatre> fetchAllTheatre() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All  theatres Fetched from DB");
		responseStructureList.setData(theatredao.fetchAllTheatre());
		return responseStructureList;
	}
	
	public  ResponseStructure<Theatre> deleteTheatreById(int theatreId) {
		Theatre theatre=theatredao.fetchTheatreById(theatreId);
		if(theatre!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully theatre deleted in DB");
		responseStructure.setData(theatredao.deleteTheatreById(theatreId));
	    return responseStructure;
		}else {
			throw new TheatreIdNotFound();
		}
		
		
	}
	
	public ResponseStructure<Theatre> updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		Theatre theatre=theatredao.fetchTheatreById(oldTheatreId);
		if(theatre!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Theatre Updated into DB");
		responseStructure.setData(theatredao.updateTheatreById(oldTheatreId, newTheatre));
		return responseStructure;
		}else {
			throw new TheatreIdNotFound();
		}
	}

}
