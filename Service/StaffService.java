package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Staffdao;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Staff;
import com.qsp.Theatre_management_system.exception.StaffIdNotFound;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class StaffService {
	
	@Autowired
	Staffdao staffdao;
	@Autowired
	ResponseStructure<Staff> responseStructure;
	
	@Autowired
	ResponseStructureList<Staff> responseStructureList;
	
	public ResponseStructure<Staff> saveStaff(Staff staff) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Staff inserted into DB");
		responseStructure.setData(staffdao.saveStaff(staff));
		return responseStructure;
	}
	
	public ResponseStructure<Staff> fetchStaffById(int staffId) {
		Staff staff=staffdao.fetchStaffById(staffId);
		if(staff!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Staff fetched from DB");
		responseStructure.setData(staffdao.fetchStaffById(staffId));
		return responseStructure;
		}else {
			throw new StaffIdNotFound();
		}
	}
	
	public ResponseStructureList<Staff> fetchAllStaff(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Staff Fetched from DB");
		responseStructureList.setData(staffdao.fetchAllStaff());
		return responseStructureList;
	}
	
	public ResponseStructure<Staff> deleteStaffById(int staffId) {
		Staff staff=staffdao.fetchStaffById(staffId);
		if(staff!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Staff deleted in DB");
		responseStructure.setData(staffdao.deleteStaffById(staffId));
	    return responseStructure;
		}else {
			throw new StaffIdNotFound();
		}
	}
	
	public ResponseStructure<Staff> updateStaffById(int oldStaffId,Staff newStaff) {
		Staff staff=staffdao.fetchStaffById(oldStaffId);
		if(staff!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Staff Updated into DB");
		responseStructure.setData(staffdao.updateStaffById(oldStaffId, newStaff));
		return responseStructure;
		}else {
		throw new StaffIdNotFound();
	}
	}
}
