package com.jdriven.ng2boot;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chimbs on 7/7/17.
 */
public  class Historic {
    @JsonProperty
    private String date;
    @JsonProperty
    private double value;

    public String getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }
}