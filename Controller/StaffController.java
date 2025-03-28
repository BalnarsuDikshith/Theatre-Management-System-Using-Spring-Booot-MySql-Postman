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

import com.qsp.Theatre_management_system.dto.Staff;
import com.qsp.Theatre_management_system.service.StaffService;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@RestController
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	@PostMapping("/saveStaff")
	public ResponseStructure<Staff> saveStaff(@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}
	
	@GetMapping("/fetchStaffById")
	public ResponseStructure<Staff> fetchStaffById(@RequestParam int staffId) {
		return staffService.fetchStaffById(staffId);
	}
	
	@GetMapping("/fetchAllStaff")
	public ResponseStructureList<Staff> fetchAllStaff(){
		return staffService.fetchAllStaff();
	}
	
	@DeleteMapping("/deleteStaffById")
	public ResponseStructure<Staff> deleteStaffById(@RequestParam int staffId) {
		return staffService.deleteStaffById(staffId);
	}
	
	@PutMapping("/updateStaffById")
	public ResponseStructure<Staff> updateStaffById(@RequestParam int oldStaffId,@RequestBody Staff newStaff) {
		return staffService.updateStaffById(oldStaffId, newStaff);
	}

}
