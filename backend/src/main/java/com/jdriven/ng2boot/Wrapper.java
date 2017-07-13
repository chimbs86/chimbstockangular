package com.jdriven.ng2boot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by chimbs on 7/6/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wrapper {
    @JsonProperty
    List<Historic> data;

    public List<Historic> getData() {
        return data;
    }
}
