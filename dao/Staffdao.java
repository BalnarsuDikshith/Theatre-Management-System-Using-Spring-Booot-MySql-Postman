package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Staff;
import com.qsp.Theatre_management_system.repo.StaffRepo;

@Repository
public class Staffdao {
	
	@Autowired
	StaffRepo staffRepo;
	
	public Staff saveStaff(Staff staff) {
		return staffRepo.save(staff);
	}
	
	public Staff fetchStaffById(int staffId) {
		Optional<Staff> dbStaff= staffRepo.findById(staffId);
		if(dbStaff.isPresent()) {
			return dbStaff.get();
		}else {
			return null;
		}
	}
	
	public List<Staff> fetchAllStaff(){
		return staffRepo.findAll();
	}
	
	public Staff deleteStaffById(int staffId) {
		Staff staff=staffRepo.findById(staffId).get();
		staffRepo.delete(staff);
		return staff;
	}
	
	public Staff updateStaffById(int oldStaffId,Staff newStaff) {
		newStaff.setStaffId(oldStaffId);
		return staffRepo.save(newStaff);
	}

}
