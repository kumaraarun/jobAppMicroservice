package com.arun.reviewms.Review;

import java.util.List;

public interface ReviewService {
	List<Review> getReviews(Long companyId);

	

	boolean createReview(Long companyId, Review review);



	



	Review getReviewsById( Long reviewId);



	boolean deleteReview( Long reviewId);



	boolean updateReview( Long reviewId, Review updatedReview);

}
