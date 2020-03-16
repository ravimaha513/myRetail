package com.retail.rest.myRetail.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURRENT_PRICE")
public class CurrentPrice {

    private float value;

    @Id
    private String currency_code;


    // Getter Methods

    public float getValue() {
        return value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    // Setter Methods

    public void setValue(float value) {
        this.value = value;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

}
