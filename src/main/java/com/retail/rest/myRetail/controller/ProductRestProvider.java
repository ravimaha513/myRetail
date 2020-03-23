package com.retail.rest.myRetail.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.retail.rest.myRetail.exception.NoRecordFoundException;
import com.retail.rest.myRetail.exception.RedSkySystemException;
import com.retail.rest.myRetail.model.Product;
import com.retail.rest.myRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductRestProvider {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable(name="id") Long productId) throws JsonProcessingException, RedSkySystemException, NoRecordFoundException {
        Product product = productService.retrieveProduct(productId);
        return product;
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody @Valid Product product) throws Exception{

        productService.createProduct(product);
        return new ResponseEntity<>("New Product Created", HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public Product modifyProduct(@RequestBody Product product) throws Exception{

        return productService.modifyProduct(product);
    }

}
