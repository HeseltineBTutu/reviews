package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import com.udacity.course3.reviews.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ProductRepository productRepository;
    /**
     * Creates a review for a product.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId,
                                                    @RequestBody Review review) {

        Optional<Product> product = productRepository.findById(productId);
        if(!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wrong product ID");
        }
        review.setProduct(product.get());
        review.setComments(Collections.emptyList());
        review.setReviewScore(review.getReviewScore());
        return ResponseEntity.status(HttpStatus.OK).body(reviewRepository.save(review));
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.EMPTY_LIST);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reviewRepository.findAllByProduct_id(productId));
    }
}