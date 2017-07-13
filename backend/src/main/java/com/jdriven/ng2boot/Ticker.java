package com.jdriven.ng2boot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chimbs on 7/6/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {
    @JsonProperty
    private String ticker;
    @JsonProperty
    private String name;
    @JsonProperty("ceo")
    private String ceo;
}
