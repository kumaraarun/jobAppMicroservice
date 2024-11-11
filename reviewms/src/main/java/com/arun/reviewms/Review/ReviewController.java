package com.arun.reviewms.Review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/reviews")
public class ReviewController {
 private ReviewService reviewService;

public ReviewController(ReviewService reviewService) {
	super();
	this.reviewService = reviewService;
}
@GetMapping
 public ResponseEntity<List<Review>> getReviews(@RequestParam Long companyId)
 {
	 return new ResponseEntity<>(reviewService.getReviews(companyId),HttpStatus.OK);
 }
@PostMapping
public ResponseEntity<String> createReviews(@RequestParam Long companyId,@RequestBody Review review) {
   boolean isReviewSaved= reviewService.createReview(companyId,review);
   if(isReviewSaved)
     return new ResponseEntity<String>("succesfully created",HttpStatus.CREATED);
   return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
   
}
@GetMapping("/{reviewId}")
public ResponseEntity<Review> getReviewsById(@PathVariable Long reviewId){
	 Review review=reviewService.getReviewsById(reviewId);
	if(review!=null)
		return new ResponseEntity<>(review,HttpStatus.OK);
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/{reviewId}")
public ResponseEntity<String> deleteReview(@PathVariable Long reviewId)
{
	boolean isDeleted=reviewService.deleteReview(reviewId);
	if(isDeleted)
		return new ResponseEntity<String>("deleted Sucessfully",HttpStatus.OK);
	return new ResponseEntity<String>("not found",HttpStatus.NOT_FOUND);
}
@PutMapping("/{reviewId}")
public ResponseEntity<String> updateReview(
		@PathVariable Long reviewId,@RequestBody Review updatedReview){
	boolean isUpdated=reviewService.updateReview(reviewId,updatedReview);
	if(isUpdated)
		return new ResponseEntity<String>("succesfully Updated",HttpStatus.OK);
	return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
}


}
