package com.arun.reviewms.Review.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.arun.reviewms.Review.Review;
import com.arun.reviewms.Review.ReviewRepository;
import com.arun.reviewms.Review.ReviewService;
@Service
public class ReviewServiceImplementation implements ReviewService {
	private ReviewRepository reviewRepository;

	public ReviewServiceImplementation(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
		
	}

	

	public List<Review> getReviews(Long companyId) {
		
		List<Review> review= reviewRepository.findByCompanyId(companyId);
		return review;
	}

	public boolean createReview(Long companyId,Review review) {
		if(review!=null && companyId!=null)
		{
		review.setCompanyId(companyId);
		reviewRepository.save(review);
		return true;
		}
		else {
			return false;
		}
		}



	@Override
	public Review getReviewsById( Long reviewId) {
		return  reviewRepository.findById(reviewId).orElse(null);
		
		
		
		
	}



	public boolean deleteReview( Long reviewId) {
		Review review=reviewRepository.findById(reviewId).orElse(null);

          if(review!=null){
			reviewRepository.delete(review);
			return true;
		}
		return false;
	}



	@Override
	public boolean updateReview( Long reviewId, Review updatedReview) {
		Review review=reviewRepository.findById(reviewId).orElse(null);
		{
			if(review!=null)
			{
				review.setTitle(updatedReview.getTitle());
				review.setDescription(updatedReview.getDescription());
				review.setDescription(updatedReview.getDescription());
				review.setCompanyId(updatedReview.getCompanyId());
				reviewRepository.save(review);
			return true;
		}

		return false;
	}
		
	}



	
}
	

