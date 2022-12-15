package com.example.review.service;

import com.example.review.model.Review;

import java.util.List;

public interface ReviewService {
    Review saveReview(Review review);
    List<Review> getAllReviews();
    Review getReviewById(Review review) throws Exception;
    Review getReviewByBookId(Review review);
}
