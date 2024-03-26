/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.service.*;
import com.example.nxttrendz1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ReviewController {

    @Autowired
    private ReviewJpaService reviewJpaService;

    @GetMapping("/products/reviews")
    public List<Review> getReviews() {
        return reviewJpaService.getReviews();
    }

    @GetMapping("/reviews/{reviewId}/product")
    public Review getReviewById(@PathVariable int reviewId) {
        return reviewJpaService.getReviewById(reviewId);
    }

   @PostMapping("/products/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewJpaService.addReview(review);
    }

   @PutMapping("/products/reviews/{reviewId}") 
    public Review updateReview(@PathVariable int reviewId, @RequestBody Review review) {
        return reviewJpaService.updateReview(reviewId, review);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        reviewJpaService.deleteReview(reviewId);
    }
}
