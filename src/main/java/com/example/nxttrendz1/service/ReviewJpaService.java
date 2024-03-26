/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.nxttrendz1.service;

import com.example.nxttrendz1.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;

@Service
public class ReviewJpaService implements ReviewRepository {

    @Autowired
    private ReviewJpaRepository reviewJpaRepository;

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public List<Review> getReviews() {
        return reviewJpaRepository.findAll();
    }

    @Override
    public Review getReviewById(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId).get();
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        try {
            reviewJpaRepository.deleteById(reviewId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product getReviewProduct(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            return review.getProduct();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review addReview(Review review) {

        Product product = review.getProduct();

        int productId = product.getProductId();

        try {
            product = productJpaRepository.findById(productId).get();

            review.setProduct(product);
            reviewJpaRepository.save(review);
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review updateReview(int reviewId, Review review) {

        try {

            Review newReview = reviewJpaRepository.findById(reviewId).get();
            if (review.getProduct() != null) {
                int productId = review.getProduct().getProductId();

                Product newProduct = productJpaRepository.findById(productId).get();

                newReview.setProduct(newProduct);
            }

            if (review.getReviewContent() != null) {
                newReview.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                newReview.setRating(review.getRating());
            }
            reviewJpaRepository.save(newReview);
            return newReview;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
