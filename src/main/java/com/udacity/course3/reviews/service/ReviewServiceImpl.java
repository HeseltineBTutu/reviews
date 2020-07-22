package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository){
        this.repository = repository;
    }
    @Override
    public Review persist(Review review){
        review.setCreateDate(LocalDate.now());
        return repository.save(review);
    }

    @Override

    public List<Review> getAllByProductId(Integer productId){
        return repository.findAllByProduct_id(productId);
    }
    @Override
    public List<Comment> getAllCommentsByReviewId(Integer reviewId){
        Optional<Review> optionalReview = repository.findById(reviewId);
        return optionalReview.map(review -> new ArrayList<>(review.getComments())).orElse(null);
    }
    @Override
    public List<Comment> createComment(Comment comment,Integer reviewId){
        Optional<Review> optionalReview = repository.findById(reviewId);
        if (!optionalReview.isPresent()){
            return null;
        }
        Review review =  optionalReview.get();
        List<Comment> comments = review.getComments();
        comments.add(comment);
        review = persist(review);
        return review.getComments();
    }
    @Override
    public Double getAverageReviewScore(Integer productId){
        List<Review> reviews = getAllByProductId(productId);
        OptionalDouble optionalScore = reviews.stream()
                .map(Review::getReviewScore)
                .filter(Objects::isNull)
                .mapToDouble(Double::valueOf)
                .average();

        return optionalScore.orElse(0.0);


    }

}
