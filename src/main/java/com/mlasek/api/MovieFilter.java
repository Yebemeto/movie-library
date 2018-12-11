package com.mlasek.api;

import com.mlasek.core.MovieGenre;
import com.mlasek.core.PersonRole;
import io.dropwizard.jersey.jsr310.LocalDateParam;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class MovieFilter {
    private MovieFilter(UUID id, String title, MovieGenre genre, String performer, PersonRole role, String origin, LocalDate dateFrom, LocalDate dateTo, Integer durationFrom, Integer durationTo) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.performer = performer;
        this.role = role;
        this.origin = origin;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.durationFrom = durationFrom;
        this.durationTo = durationTo;
    }

    private UUID id;
    private String title;
    private MovieGenre genre;
    private String performer;
    private PersonRole role;
    private String origin;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer durationFrom;
    private Integer durationTo;

    public static MovieFilter.Builder builder() {
        return new MovieFilter.Builder();
    }

    public static class Builder{
        private UUID id;
        private String title;
        private MovieGenre genre;
        private String performer;
        private PersonRole role;
        private String origin;
        private LocalDate dateFrom;
        private LocalDate dateTo;
        private Integer durationFrom;
        private Integer durationTo;

        public Builder withId(UUID id){
            this.id = id;
            return this;
        }

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public Builder withGenre(MovieGenre genre){
            this.genre = genre;
            return this;
        }

        public Builder withPerformer(String performer){
            this.performer = performer;
            return this;
        }

        public Builder withRole(PersonRole role){
            this.role = role;
            return this;
        }

        public Builder withOrigin(String origin){
            this.origin = origin;
            return this;
        }

        public Builder withDateFrom(Optional<LocalDateParam> dateFrom){
            if(dateFrom.isPresent()) {
                this.dateFrom = dateFrom.get().get();
            }
            return this;
        }

        public Builder withDateTo(Optional<LocalDateParam> dateTo){
            if(dateTo.isPresent()) {
                this.dateTo = dateTo.get().get();
            }
            return this;
        }

        public Builder withDurationFrom(Integer durationFrom){
            this.durationFrom = durationFrom;
            return this;
        }

        public Builder withDurationTo(Integer durationTo){
            this.durationTo = durationTo;
            return this;
        }

        public MovieFilter build(){
            return new MovieFilter(id, title, genre, performer, role, origin, dateFrom, dateTo, durationFrom, durationTo);
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

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getDurationFrom() {
        return durationFrom;
    }

    public void setDurationFrom(Integer durationFrom) {
        this.durationFrom = durationFrom;
    }

    public Integer getDurationTo() {
        return durationTo;
    }

    public void setDurationTo(Integer durationTo) {
        this.durationTo = durationTo;
    }
}
