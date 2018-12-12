package com.mlasek.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.*;

public class Movie {
    public Movie(UUID id, String title, List<MovieGenre> genres, List<Performance> performers, String countryOfOrigin, String description, LocalDate releaseDate, Integer duration) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.performers = performers;
        this.countryOfOrigin = countryOfOrigin;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public Movie() {
    }

    private UUID id;
    @NotEmpty
    private String title;
    private List<MovieGenre> genres = new ArrayList<>();
    private List<Performance> performers = new ArrayList<>();
    private String countryOfOrigin;
    private String description;
    private LocalDate releaseDate;
    private Integer duration;

    public static Movie.Builder builder() {
        return new Movie.Builder();
    }

    public static class Builder {
        private UUID id;
        private String title;
        private List<MovieGenre> genres = new ArrayList<>();
        private List<Performance> performers = new ArrayList<>();
        private String countryOfOrigin;
        private String description;
        private LocalDate releaseDate;
        private Integer duration;

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withGenres(List<MovieGenre> genres) {
            this.genres = genres;
            return this;
        }

        public Builder withPerformers(List<Performance> performers){
            this.performers = performers;
            return this;
        }

        public Builder withCountryOfOrigin(String countryOfOrigin) {
            this.countryOfOrigin = countryOfOrigin;
            return this;
        }

        public Builder withReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Movie build() {
            return new Movie(id, title, genres, performers, countryOfOrigin, description, releaseDate, duration);
        }
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

}