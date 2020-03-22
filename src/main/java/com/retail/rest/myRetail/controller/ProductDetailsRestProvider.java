package com.retail.rest.myRetail.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.rest.myRetail.model.ProductDetails;

@RestController
@RequestMapping(value = "/v2/pdp/", produces = {"application/json"})
public class ProductDetailsRestProvider {
	
	@GetMapping("/tcin/{id}")
	public ResponseEntity<?> retrieveEventData(){
		return null;
	}
	
	@PostMapping("/product")
	public @ResponseBody ResponseEntity<?> createEventData(@Valid @RequestBody ProductDetails productDetails){
		return null;
		
	}
}
