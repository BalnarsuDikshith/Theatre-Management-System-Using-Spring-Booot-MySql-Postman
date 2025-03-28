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

import com.qsp.Theatre_management_system.dto.Screen;
import com.qsp.Theatre_management_system.service.ScreenService;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@RestController
public class ScreenController {
	
	@Autowired
	ScreenService screenService;
	
	@PostMapping("/saveScreen")
	public ResponseStructure<Screen> saveScreen(@RequestBody Screen screen) {
		return screenService.saveScreen(screen);
	}
	
	@PutMapping("/addExistingMovieToExistingScreen")
	public Screen addExistingMovieToExistingScreen(@RequestParam int movieId,@RequestParam int screenId) {
		return screenService.addExistingMovieToExistingScreen( movieId, screenId);
	}
	
	@GetMapping("/fetchScreenById")
	public ResponseStructure<Screen> fetchScreenById(@RequestParam int screenId) {
		return screenService.fetchScreenById(screenId);
	}
	
	@GetMapping("/fetchAllScreen")
	public ResponseStructureList<Screen> fetchAllScreen(){
		return screenService.fetchAllScreen();
	}
	
	@DeleteMapping("/deleteScreenById")
	public ResponseStructure<Screen> deleteScreenById(@RequestParam int screenId) {
		return screenService.deleteScreenById(screenId);
	}
	
	@PutMapping("/updateScreenById")
	public ResponseStructure<Screen> updateScreenById(@RequestParam int oldScreenId,@RequestBody Screen newScreen) {
		return screenService.updateScreenById(oldScreenId, newScreen);
	}
}
