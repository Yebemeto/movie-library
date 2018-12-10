package com.mlasek.api;

import com.mlasek.core.MovieGenre;
import com.mlasek.core.PersonRole;
import io.dropwizard.jersey.jsr310.LocalDateParam;

import java.util.UUID;

public class MovieFilter {
    private MovieFilter(UUID id, String title, MovieGenre genre, String performer, PersonRole role, String origin, LocalDateParam dateFrom, LocalDateParam dateTo) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.performer = performer;
        this.role = role;
        this.origin = origin;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    private UUID id;
    private String title;
    private MovieGenre genre;
    private String performer;
    private PersonRole role;
    private String origin;
    private LocalDateParam dateFrom;
    private LocalDateParam dateTo;

    public static class MovieFilterBuilder{
        private UUID id;
        private String title;
        private MovieGenre genre;
        private String performer;
        private PersonRole role;
        private String origin;
        private LocalDateParam dateFrom;
        private LocalDateParam dateTo;

        public MovieFilterBuilder withId(UUID id){
            this.id = id;
            return this;
        }

        public MovieFilterBuilder withTitle(String title){
            this.title = title;
            return this;
        }

        public MovieFilterBuilder withGenre(MovieGenre genre){
            this.genre = genre;
            return this;
        }

        public MovieFilterBuilder withPerformer(String performer){
            this.performer = performer;
            return this;
        }

        public MovieFilterBuilder withRole(PersonRole role){
            this.role = role;
            return this;
        }

        public MovieFilterBuilder withOrigin(String origin){
            this.origin = origin;
            return this;
        }

        public MovieFilterBuilder withDateFrom(LocalDateParam dateFrom){
            this.dateFrom = dateFrom;
            return this;
        }

        public MovieFilterBuilder withDateTo(LocalDateParam dateTo){
            this.dateTo = dateTo;
            return this;
        }

        public MovieFilter build(){
            return new MovieFilter(id, title, genre, performer, role, origin, dateFrom, dateTo);
        }
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

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public PersonRole getRole() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDateParam getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateParam dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateParam getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateParam dateTo) {
        this.dateTo = dateTo;
    }
}
