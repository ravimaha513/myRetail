package com.retail.rest.myRetail.repository;

import com.retail.rest.myRetail.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {
}
