package com.retail.rest.myRetail.controller;

import com.retail.rest.myRetail.model.Product;
import com.retail.rest.myRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestProvider {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public Product getEmployees(@PathVariable(name="id") Long productId) {
        Product product = productService.retrieveProduct(productId);
        return product;
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        //return ResponseEntity.created();
        return null;
    }

}
