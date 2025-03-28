package com.qsp.Theatre_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	private String theatreName;
	private String theatreGst;
	private String theatreEmail;
	private long theatrePhone;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branches;
	
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreGst() {
		return theatreGst;
	}
	public void setTheatreGst(String theatreGst) {
		this.theatreGst = theatreGst;
	}
	public String getTheatreEmail() {
		return theatreEmail;
	}
	public void setTheatreEmail(String theatreEmail) {
		this.theatreEmail = theatreEmail;
	}
	public long getTheatrePhone() {
		return theatrePhone;
	}
	public void setTheatrePhone(long theatrePhone) {
		this.theatrePhone = theatrePhone;
	}
	public List<Branch> getBranches() {
		return branches;
	}
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	
	
	
	

}
