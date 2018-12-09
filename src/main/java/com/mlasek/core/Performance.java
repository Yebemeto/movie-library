package com.mlasek.core;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Performance {
    private String performerName;
    private PersonRole role;

    @JsonProperty
    public String getPerformerName() {
        return performerName;
    }

    @JsonProperty
    public PersonRole getRole() {
        return role;
    }

}
