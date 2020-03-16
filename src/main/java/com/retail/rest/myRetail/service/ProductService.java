package com.retail.rest.myRetail.service;

import com.retail.rest.myRetail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository prodRepo;


}
