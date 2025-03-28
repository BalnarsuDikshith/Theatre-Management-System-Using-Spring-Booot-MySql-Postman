package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Manager;
import com.qsp.Theatre_management_system.repo.ManagerRepo;

@Repository
public class Managerdao {
	
	@Autowired
	ManagerRepo managerRepo;
	
	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}
	
	public Manager fetchManagerById(int managerId) {
		Optional<Manager> dbManager=managerRepo.findById(managerId);
		if(dbManager.isPresent()) {
			return dbManager.get();
		}else {
			return null;
		}
	}
	
	public List<Manager> fetchAllManager(){
		return managerRepo.findAll();
	}
	
	public Manager deleteManagerById(int managerId) {
		Manager manager= managerRepo.findById(managerId).get();
		managerRepo.delete(manager);
		return manager;
	}
	
	public Manager updateManagerById(int oldManagerId, Manager newManager) {
		newManager.setManagerId(oldManagerId);
		return managerRepo.save(newManager);
	}
	

}
