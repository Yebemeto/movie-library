package com.mlasek.core;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Performance {
    private String performerName;
    private Role role;

    @JsonProperty
    public String getPerformerName() {
        return performerName;
    }

    @JsonProperty
    public Role getRole() {
        return role;
    }

}
