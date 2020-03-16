package com.retail.rest.myRetail.model;

public class CurrentPrice {

    private float value;
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
