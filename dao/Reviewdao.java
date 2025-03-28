package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Review;
import com.qsp.Theatre_management_system.repo.ReviewRepo;

@Repository
public class Reviewdao {

	@Autowired
	ReviewRepo reviewRepo;
	
	public Review saveReview(Review review) {
		return reviewRepo.save(review);
	}
	
	public Review fetchReviewById(int reviewId) {
		Optional<Review> dbReview=reviewRepo.findById(reviewId);
		if(dbReview.isPresent()) {
			return dbReview.get();
		}else {
			return null;
		}
		
	}
	
	public List<Review> fetchAllReview(){
		return reviewRepo.findAll();
	}
	
	public Review deleteReviewById(int reviewId) {
		Review review= reviewRepo.findById(reviewId).get();
	reviewRepo.delete(review);
		return review;
	}
	
	public Review updateReviewById(int oldReviewId, Review newReview) {
		newReview.setReviewId(oldReviewId);
		return reviewRepo.save(newReview);
	}
}


