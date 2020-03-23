package com.retail.rest.myRetail.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.rest.myRetail.exception.NoRecordFoundException;
import com.retail.rest.myRetail.exception.RedSkySystemException;
import com.retail.rest.myRetail.model.Product;
import com.retail.rest.myRetail.model.ProductDetails;
import com.retail.rest.myRetail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductService {

    @Autowired
    ProductRepository prodRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${target.redsky.url}")
    private String restURL;

    @Value("${target.redsky.queryParam}")
    private String queryParam;

    public Product retrieveProduct(long id) throws JsonProcessingException, RedSkySystemException , NoRecordFoundException {
        Optional<Product> productOpt = prodRepo.findById(id);
        Product product;
        if(productOpt.isPresent()){
            product = productOpt.get();
            String productName = getProductName(id);
            product.setName(productName);

        }else{
            throw new NoRecordFoundException("NO RECORD FOUND FOR: {}" + id);
        }

        return product;
    }

    public void createProduct(Product product){

        prodRepo.save(product);
    }

    public Product modifyProduct(Product product) throws Exception{
        Product productUpdate = retrieveProduct(product.getId());
        productUpdate.setCurrent_price(product.getCurrent_price());
        productUpdate.setId(product.getId());
        productUpdate.setName(product.getName());
        prodRepo.save(product);

        return productUpdate;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String getProductName(long productId) throws JsonProcessingException, RedSkySystemException {
        restURL = restURL + productId + queryParam;
        System.out.print(restURL);
        ResponseEntity<String> response= restTemplate.getForEntity(restURL, String.class);
        String productName ="";
        ObjectMapper mapper = new ObjectMapper();
        HttpStatus responseCode = response.getStatusCode();
        if(responseCode.value() == 200){
            JsonNode node = mapper.readTree(response.getBody());
            productName = node.findValue("product").findValue("item").findValue("product_description").findValue("title").asText();
        }else{
            throw new RedSkySystemException("RedSky Server Not Available {}" + response.getStatusCode().toString());
        }

        return productName;
    }

    public String reliable() {
        return "SERVICE TEMPORARILY UNAVAILABLE";
    }
}
