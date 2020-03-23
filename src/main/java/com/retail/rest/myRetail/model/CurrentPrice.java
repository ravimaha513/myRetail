package com.retail.rest.myRetail.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;



@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CurrentPrice {

    private BigDecimal value;
    private String currency_code;

}
