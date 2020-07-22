package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository){

        this.repository =repository;

    }
    @Override
    public Product persist(Product product){
        return repository.save(product);
    }
    @Override
    public Optional<Product> getProductById(Integer id){
        return repository.findById(id);
    }
    @Override
    public List<Product> findAllProducts(){
        return repository.findAll();
    }

}
