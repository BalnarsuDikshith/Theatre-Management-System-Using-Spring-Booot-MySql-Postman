package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Managerdao;
import com.qsp.Theatre_management_system.dto.Manager;
import com.qsp.Theatre_management_system.exception.ManagerIdNotFound;
import com.qsp.Theatre_management_system.dto.Manager;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class ManagerService {
	
	@Autowired
	Managerdao managerdao;
	
	@Autowired
	ResponseStructure<Manager> responseStructure;
	@Autowired
	ResponseStructureList<Manager> responseStructureList;
	
	public ResponseStructure<Manager> saveManager(Manager manager) {
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Manager inserted into DB");
		responseStructure.setData(managerdao.saveManager(manager));
		return responseStructure;
	}
	
	public ResponseStructure<Manager> fetchManagerById(int managerId) {
		Manager manager=managerdao.fetchManagerById(managerId);
		if(manager!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Manager fetched from DB");
		responseStructure.setData(managerdao.fetchManagerById(managerId));
		return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
	}

	
	public ResponseStructureList<Manager> fetchAllManager(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Managers Fetched from DB");
		responseStructureList.setData(managerdao.fetchAllManager());
		return responseStructureList;
		
	}
	
	public ResponseStructure<Manager> deleteManagerById(int managerId) {
		Manager manager=managerdao.fetchManagerById(managerId);
		if(manager!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Manager deleted in DB");
		responseStructure.setData(managerdao.deleteManagerById(managerId));
	    return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
	    
	}
	
	public ResponseStructure<Manager> updateManagerById(int oldManagerId,Manager newManager)
	{	
		Manager manager=managerdao.fetchManagerById(oldManagerId);
		if(manager!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Manager Updated into DB");
		responseStructure.setData(managerdao.updateManagerById(oldManagerId,newManager));
		return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
	}
}
