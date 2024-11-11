package com.arun.JobApp.Review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.JobApp.Company.Company;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
 private ReviewService reviewService;

public ReviewController(ReviewService reviewService) {
	super();
	this.reviewService = reviewService;
}
@GetMapping("/reviews")
 public ResponseEntity<List<Review>> getReviews(@PathVariable Long companyId)
 {
	 return new ResponseEntity<>(reviewService.getReviews(companyId),HttpStatus.OK);
 }
@PostMapping("/reviews")
public ResponseEntity<String> createReviews(@PathVariable Long companyId,@RequestBody Review review) {
   boolean isReviewSaved= reviewService.createReview(companyId,review);
   if(isReviewSaved)
     return new ResponseEntity<String>("succesfully created",HttpStatus.CREATED);
   return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
   
}
@GetMapping("/reviews/{reviewId}")
public ResponseEntity<Review> getReviewsById(@PathVariable Long companyId,@PathVariable Long reviewId){
	 Review review=reviewService.getReviewsById(companyId,reviewId);
	if(review!=null)
		return new ResponseEntity<>(review,HttpStatus.OK);
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/reviews/{reviewId}")
public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId)
{
	boolean isDeleted=reviewService.deleteReview( companyId, reviewId);
	if(isDeleted)
		return new ResponseEntity<String>("deleted Sucessfully",HttpStatus.OK);
	return new ResponseEntity<String>("not found",HttpStatus.NOT_FOUND);
}
@PutMapping("/reviews/{reviewId}")
public ResponseEntity<String> updateReview(@PathVariable Long companyId,
		@PathVariable Long reviewId,@RequestBody Review updatedReview){
	boolean isUpdated=reviewService.updateReview(companyId,reviewId,updatedReview);
	if(isUpdated)
		return new ResponseEntity<String>("succesfully Updated",HttpStatus.OK);
	return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
}


}
