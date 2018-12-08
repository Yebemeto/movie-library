package com.mlasek.core;

import com.google.common.base.Objects;

import java.util.*;

public class Movie {
    private UUID id;
    private String title;
    private Map<PersonRole,List<Person>> peopleInvolved = new HashMap<>();
    private List<MovieGenre> genres;
    private List<Performance> performers;
    private Locale countryOfOriginLocale;
    private String description;

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

    public Map<PersonRole, List<Person>> getPeopleInvolved() {
        return peopleInvolved;
    }

    public void setPeopleInvolved(Map<PersonRole, List<Person>> peopleInvolved) {
        this.peopleInvolved = peopleInvolved;
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

    public Locale getCountryOfOriginLocale() {
        return countryOfOriginLocale;
    }

    public void setCountryOfOriginLocale(Locale countryOfOriginLocale) {
        this.countryOfOriginLocale = countryOfOriginLocale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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