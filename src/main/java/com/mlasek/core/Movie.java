package com.mlasek.core;

import com.google.common.base.Objects;

import java.time.LocalDate;
import java.util.*;

public class Movie {
    private UUID id;
    private String title;
    private List<MovieGenre> genres;
    private List<Performance> performers;
    private String countryOfOrigin;
    private String description;
    private LocalDate productionDate;

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieGenre> genres) {
        this.genres = genres;
    }

    public List<Performance> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performance> performers) {
        this.performers = performers;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateIgnoreId(Movie movie){
        this.countryOfOrigin = movie.getCountryOfOrigin();
        this.description = movie.getDescription();
        this.genres = movie.getGenres();
        this.performers = movie.getPerformers();
        this.title = movie.getTitle();
        this.productionDate = movie.getProductionDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equal(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}