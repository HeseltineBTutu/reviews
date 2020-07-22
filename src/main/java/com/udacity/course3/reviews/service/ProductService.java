package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product persist(Product product);
    Optional<Product> getProductById(Integer id);
    List<Product> findAllProducts();
}
