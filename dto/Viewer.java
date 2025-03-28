package com.qsp.Theatre_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Viewer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int viewerId;
	private String viewerName;
	private long viewerPhone;
	private String viewerEmail;
	private String viewerGender;
	private int viewerAge;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Food> foods;
	
	public int getViewerId() {
		return viewerId;
	}
	public void setViewerId(int viewerId) {
		this.viewerId = viewerId;
	}
	public String getViewerName() {
		return viewerName;
	}
	public void setViewerName(String viewerName) {
		this.viewerName = viewerName;
	}
	public long getViewerPhone() {
		return viewerPhone;
	}
	public void setViewerPhone(long viewerPhone) {
		this.viewerPhone = viewerPhone;
	}
	public String getViewerEmail() {
		return viewerEmail;
	}
	public void setViewerEmail(String viewerEmail) {
		this.viewerEmail = viewerEmail;
	}
	public String getViewerGender() {
		return viewerGender;
	}
	public void setViewerGender(String viewerGender) {
		this.viewerGender = viewerGender;
	}
	public int getViewerAge() {
		return viewerAge;
	}
	public void setViewerAge(int viewerAge) {
		this.viewerAge = viewerAge;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	
	
	
	

}
