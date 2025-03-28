package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Movie;
import com.qsp.Theatre_management_system.dto.Screen;
import com.qsp.Theatre_management_system.dto.Seat;
import com.qsp.Theatre_management_system.dto.Staff;
import com.qsp.Theatre_management_system.dto.Viewer;
import com.qsp.Theatre_management_system.repo.ScreenRepo;

@Repository
public class Screendao {
	
	@Autowired
	ScreenRepo screenRepo;
	@Autowired
	Moviedao moviedao;
	
	public Screen saveScreen(Screen screen) {
		return screenRepo.save(screen);
	}
	
	public Screen addExistingMovieToExistingScreen(int movieId,int screenId) {
		Movie movie=moviedao.fetchMovieById(movieId);
		Screen screen=fetchScreenById(screenId);
		screen.setMovie(movie);
		return saveScreen(screen);
	}
	
	public Screen fetchScreenById(int screenId) {
		Optional<Screen> dbScreen=screenRepo.findById(screenId);
		if(dbScreen.isPresent()) {
			return dbScreen.get();
		}else {
			return null;
		}
		
	}
	
	public List<Screen> fetchAllScreen(){
		return screenRepo.findAll();
	}
	
	public Screen deleteScreenById(int screenId) {
		Screen screen=screenRepo.findById(screenId).get();
		screenRepo.delete(screen);
		return screen;
	}
	
	public Screen updateScreenById(int oldScreenId,Screen newScreen) {
		newScreen.setScreenId(oldScreenId);
		return screenRepo.save(newScreen);
	}
}
