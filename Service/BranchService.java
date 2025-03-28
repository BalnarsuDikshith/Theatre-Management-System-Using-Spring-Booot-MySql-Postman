package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Branchdao;
import com.qsp.Theatre_management_system.dto.Address;
import com.qsp.Theatre_management_system.dto.Branch;
import com.qsp.Theatre_management_system.dto.Manager;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Screen;
import com.qsp.Theatre_management_system.dto.Staff;
import com.qsp.Theatre_management_system.exception.BranchIdNotFound;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class BranchService {
	@Autowired
	Branchdao branchdao;
	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	
	public ResponseStructure<Branch> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Branch inserted into DB");
		responseStructure.setData(branchdao.saveBranch(branch));
		return responseStructure;
	}
	
	public Branch addExistingManagerToExistingBranch(int managerId,int branchId) {
		return branchdao.addExistingManagerToExistingBranch(managerId, branchId);
	}
	
	public Branch addExistingAddressToExistingBranch(int addressId,int branchId) {
		return branchdao.addExistingAddressToExistingBranch(addressId, branchId);
	}
	
	public Branch addExistingStaffToExistingBranch(int staffId,int branchId) {
		return branchdao.addExistingStaffToExistingBranch(staffId, branchId);
	}
	
	public Branch addNewStaffToExistingBranch(int branchId, Staff newStaff) {
		return branchdao.addNewStaffToExistingBranch(branchId, newStaff);
		
	}
	
	public Branch addExistingScreenToExistingBranch(int screenId,int branchId) {
		return branchdao.addExistingScreenToExistingBranch(screenId, branchId);
	}
	
	public Branch addNewScreenToExistingBranch(int branchId, Screen newScreen) {
	return branchdao.addNewScreenToExistingBranch(branchId, newScreen);
		
	}
	
	
	
	public ResponseStructure<Branch> fetchBranchById(int branchId) {
		Branch branch=branchdao.fetchBranchById(branchId);
		if(branch!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Branch fetches from DB");
		responseStructure.setData(branchdao.fetchBranchById(branchId));
		return responseStructure;
		}else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseStructureList<Branch> fetchAllBranch(){

		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Branches Fetched from DB");
		responseStructureList.setData(branchdao.fetchAllBranch());
		return responseStructureList;
	}
	
	public ResponseStructure<Branch> deleteBranchById(int branchId) {
		Branch branch=branchdao.fetchBranchById(branchId);
		if(branch!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch deleted in DB");
		responseStructure.setData(branchdao.deleteBranchById(branchId));
	    return responseStructure;
		}else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseStructure<Branch> updateBranchById(int oldBranchId,Branch newBranch) {
		Branch branch=branchdao.fetchBranchById(oldBranchId);
		if(branch!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch Updated into DB");
		responseStructure.setData(branchdao.updateBranchById(oldBranchId, newBranch));
		return responseStructure;
		}else {
			throw new BranchIdNotFound();
		}
	}

}
