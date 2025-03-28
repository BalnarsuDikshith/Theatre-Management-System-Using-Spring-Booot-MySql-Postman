package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Branch;
import com.qsp.Theatre_management_system.dto.Movie;
import com.qsp.Theatre_management_system.dto.Review;
import com.qsp.Theatre_management_system.dto.Screen;
import com.qsp.Theatre_management_system.dto.Viewer;
import com.qsp.Theatre_management_system.repo.MovieRepo;

@Repository
public class Moviedao {

	@Autowired
	MovieRepo movieRepo;
	@Autowired
	Viewerdao viewerdao;
	@Autowired
	Reviewdao reviewdao;
	
	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	
	public Movie addExistingViewerToExistingMovie(int viewerId,int movieId) {
	Viewer viewer=viewerdao.fetchViewerById(viewerId);
	Movie movie=fetchMovieById(movieId);
	List<Viewer> list=movie.getViewers();
	list.add(viewer);
	movie.setViewers(list);
	return saveMovie(movie);	
	}
	
	public Movie addNewViewerToExistingMovie(int movieId, Viewer newViewer) {
		
		Movie movie=fetchMovieById(movieId);
		List<Viewer> list=movie.getViewers();
		list.add(newViewer);
		movie.setViewers(list);
		return saveMovie(movie);	
		}
		 
	public Movie addExistingReviewToExistingMovie(int reviewId,int movieId) {
		Review review=reviewdao.fetchReviewById(reviewId);
		Movie movie=fetchMovieById(movieId);
		List<Review> list=movie.getReviews();
		list.add(review);
		movie.setReviews(list);;
		return saveMovie(movie);	
		}
		
		public Movie addNewReviewToExistingMovie(int movieId, Review newReview) {
			
			Movie movie=fetchMovieById(movieId);
			List<Review> list=movie.getReviews();
			list.add(newReview);
			movie.setReviews(list);
			return saveMovie(movie);	
			}
			
	
	
	public Movie fetchMovieById(int movieId) {
		Optional<Movie> dbMovie=movieRepo.findById(movieId);
		if(dbMovie.isPresent()) {
			return dbMovie.get();
		}else {
			return null;
		}
	}
		
		
	
	public List<Movie> fetchAllMovie(){
		return movieRepo.findAll();
	}
	
	public Movie deleteMovieById(int movieId) {
		Movie movie= movieRepo.findById(movieId).get();
		movieRepo.delete(movie);
		return movie;
	}
	
	public Movie updateMovieById(int oldMovieId, Movie newMovie) {
		newMovie.setMovieId(oldMovieId);
		return movieRepo.save(newMovie);
	}
	
	
}
