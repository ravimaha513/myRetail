package com.retail.rest.myRetail.service;

import com.retail.rest.myRetail.model.Product;
import com.retail.rest.myRetail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository prodRepo;


    public Product retrieveProduct(long id){
        Product product = (Product) prodRepo.findById(id).get();
        return product;
    }

    public void createProduct(Product product){
        prodRepo.save(product);
    }
}
