package com.mlasek.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.*;

public class Movie {
    private UUID id;
    @NotEmpty
    private String title;
    private List<MovieGenre> genres = new ArrayList<>();
    private List<Performance> performers = new ArrayList<>();
    private String countryOfOrigin;
    private String description;
    private LocalDate releaseDate;
    private Integer duration;

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonProperty
    public UUID getId() {
        return id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public List<MovieGenre> getGenres() {
        return genres;
    }

    @JsonProperty
    public List<Performance> getPerformers() {
        return performers;
    }

    @JsonProperty
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty
    public Integer getDuration() {
        return duration;
    }

    public void updateIgnoreId(Movie movie){
        this.countryOfOrigin = movie.getCountryOfOrigin();
        this.description = movie.getDescription();
        this.genres = movie.getGenres();
        this.performers = movie.getPerformers();
        this.title = movie.getTitle();
        this.releaseDate = movie.getReleaseDate();
        this.duration = movie.getDuration();
    }

}