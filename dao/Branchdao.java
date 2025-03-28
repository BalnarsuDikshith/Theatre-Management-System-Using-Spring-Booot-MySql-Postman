package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Address;
import com.qsp.Theatre_management_system.dto.Branch;
import com.qsp.Theatre_management_system.dto.Manager;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Screen;
import com.qsp.Theatre_management_system.dto.Staff;
import com.qsp.Theatre_management_system.dto.Theatre;
import com.qsp.Theatre_management_system.repo.BranchRepo;

@Repository
public class Branchdao {
	@Autowired
	BranchRepo branchrepo;
	@Autowired
	Managerdao managerdao;
	@Autowired
	Addressdao addressdao;
	@Autowired
	Staffdao staffdao;
	@Autowired
	Screendao screendao;
	
	public Branch saveBranch(Branch branch) {
		return branchrepo.save(branch);
	}
	
	public Branch addExistingManagerToExistingBranch(int managerId,int branchId) {
		Manager manager=managerdao.fetchManagerById(managerId);
		Branch branch=fetchBranchById(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}
	
	public Branch addExistingAddressToExistingBranch(int addressId,int branchId) {
		Address address=addressdao.fetchAddressById(addressId);
		Branch branch=fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addExistingStaffToExistingBranch(int staffId,int branchId) {
		Staff staff=staffdao.fetchStaffById(staffId);
		Branch branch=fetchBranchById(branchId);
		List<Staff> list=branch.getStaffs();
		list.add(staff);
		branch.setStaffs(list);
		return saveBranch(branch);
		
		
	}
	
	public Branch addNewStaffToExistingBranch(int branchId, Staff newStaff) {
		
		Branch branch=fetchBranchById(branchId);
		List<Staff> list=branch.getStaffs();
		list.add(newStaff);
		branch.setStaffs(list);
		return saveBranch(branch);
		
	}
	
	public Branch addExistingScreenToExistingBranch(int screenId,int branchId) {
		Screen screen=screendao.fetchScreenById(screenId);
		Branch branch=fetchBranchById(branchId);
		List<Screen> list=branch.getScreens();
		list.add(screen);
		branch.setScreens(list);
		return saveBranch(branch);
		
		
	}
	
	public Branch addNewScreenToExistingBranch(int branchId, Screen newScreen) {
		
		Branch branch=fetchBranchById(branchId);
		List<Screen> list=branch.getScreens();
		list.add(newScreen);
		branch.setScreens(list);
		return saveBranch(branch);
		
	}
	
	
	public Branch fetchBranchById(int branchId) {
		Optional<Branch> dbBranch= branchrepo.findById(branchId);
		if(dbBranch.isPresent()) {
			return dbBranch.get();
		}else {
			return null;
		}
	}
	
	public List<Branch> fetchAllBranch() {
		
		return branchrepo.findAll();
		
	}
	
	public Branch deleteBranchById(int branchId) {
		Branch branch=fetchBranchById(branchId);
		branchrepo.delete(branch);
	    return branch;
	}
		
	public Branch updateBranchById(int oldBranchId,Branch newBranch)
	{
		newBranch.setBranchId(oldBranchId);
		//return saveBranch(newBranch);
		return branchrepo.save(newBranch);
	}

	
	

}
