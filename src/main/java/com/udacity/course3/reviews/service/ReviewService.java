package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    Review persist(Review review);
    List<Review> getAllByProductId(Integer id);
    List<Comment> getAllCommentsByReviewId(Integer reviewId);
    List<Comment> createComment(Comment comment,Integer reviewId);

    Double getAverageReviewScore(Integer productId);

}
