package com.arun.jobms.Job.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.arun.jobms.Job.External.Company;
import com.arun.jobms.Job.External.Review;
@FeignClient(name = "REVIEW-SERVICE")
public interface ReviewClient {
	
		@GetMapping("/reviews")
		List<Review> getReviews(@RequestParam("companyId") Long companyId);

}
