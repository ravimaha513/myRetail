package com.retail.rest.myRetail.controller;

import com.retail.rest.myRetail.model.Product;
import com.retail.rest.myRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestProvider {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public List<Product> getEmployees(@PathVariable(name="id") Long productId) {
        List<Product> employees = productService.retrieveEmployees();
        return employees;
    }
}
