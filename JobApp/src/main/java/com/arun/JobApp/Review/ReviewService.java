package com.arun.JobApp.Review;

import java.util.List;

public interface ReviewService {
	List<Review> getReviews(Long companyId);

	

	boolean createReview(Long companyId, Review review);



	



	Review getReviewsById(Long companyId, Long reviewId);



	boolean deleteReview(Long companyId, Long reviewId);



	boolean updateReview(Long companyId, Long reviewId, Review updatedReview);

}
