/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here

package com.example.nxttrendz1.model;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
    private int reviewId;
    @Column(name = "reviewcontent")
    private String reviewContent;

    @Column(name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    // Constructors
    public Review() {
    }

    public Review(String reviewContent, int rating, Product product) {
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.product = product;
    }

    // Getters and Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
