package com.myproject1.product_service.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myproject1.product_service.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
 