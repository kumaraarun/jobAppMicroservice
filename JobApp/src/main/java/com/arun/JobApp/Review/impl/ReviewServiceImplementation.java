package com.arun.JobApp.Review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arun.JobApp.Company.Company;
import com.arun.JobApp.Company.CompanyService;
import com.arun.JobApp.Review.Review;
import com.arun.JobApp.Review.ReviewRepository;
import com.arun.JobApp.Review.ReviewService;
@Service
public class ReviewServiceImplementation implements ReviewService {
	private ReviewRepository reviewRepository;
	private CompanyService companyService;

	public ReviewServiceImplementation(ReviewRepository reviewRepository, CompanyService companyService) {
		super();
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}

	

	public List<Review> getReviews(Long companyId) {
		
		List<Review> review= reviewRepository.findByCompanyId(companyId);
		return review;
	}

	public boolean createReview(Long companyId,Review review) {
		Company company=companyService.findCompaniesById(companyId);
		if(company!=null)
		{
		review.setCompany(company);
		reviewRepository.save(review);
		return true;
		}
		else {
			return false;
		}
		}



	@Override
	public Review getReviewsById(Long companyId, Long reviewId) {
		List<Review> reviews =reviewRepository.findByCompanyId(companyId);
		return reviews.stream()
				.filter(review->review.getId().equals(reviewId))
				.findFirst().orElse(null);
		
		
		
		
	}



	public boolean deleteReview(Long companyId, Long reviewId) {
		if(companyService.findCompaniesById(companyId)!=null && reviewRepository.existsById(reviewId))
		{
			Review review=reviewRepository.findById(reviewId).orElse(null);
			Company company=review.getCompany();
			company.getReviews().remove(review);
			review.setCompany(null);
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}



	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
		if(companyService.findCompaniesById(companyId)!=null)
		{
			updatedReview.setCompany(companyService.findCompaniesById(companyId));
			updatedReview.setId(reviewId);
			reviewRepository.save(updatedReview);
			return true;
		}

		return false;
	}
		
	}
	

