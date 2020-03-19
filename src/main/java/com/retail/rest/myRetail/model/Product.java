package com.retail.rest.myRetail.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="PRODUCT")
public class Product {
    @Id
    private long id;
    private String name;

    @Transient
    CurrentPrice current_priceObject;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CurrentPrice getCurrent_price() {
        return current_priceObject;
    }

    // Setter Methods

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrent_price(CurrentPrice current_priceObject) {
        this.current_priceObject = current_priceObject;
    }
}
