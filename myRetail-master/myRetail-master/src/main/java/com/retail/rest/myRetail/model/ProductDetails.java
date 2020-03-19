package com.retail.rest.myRetail.model;

import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "PRODUCT_DETAILS")
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ProductDetails {

	long productId;
	String productName;
	
	
}
