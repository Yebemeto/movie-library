package com.mlasek.api;

import com.mlasek.core.MovieGenre;
import com.mlasek.core.Role;
import io.dropwizard.jersey.jsr310.LocalDateParam;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class MovieFilter implements Serializable {
    private MovieFilter(UUID id, String title, MovieGenre genre, String performer, Role role, String origin, LocalDate dateFrom, LocalDate dateTo, Integer durationFrom, Integer durationTo) {
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
    private Role role;
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
        private Role role;
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

        public Builder withRole(Role role){
            this.role = role;
            return this;
        }

        public Builder withOrigin(String origin){
            this.origin = origin;
            return this;
        }

        public Builder withDateFrom(LocalDate dateFrom){
            this.dateFrom = dateFrom;
            return this;
        }

        public Builder withDateTo(LocalDate dateTo){
            this.dateTo = dateTo;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieFilter that = (MovieFilter) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (genre != that.genre) return false;
        if (performer != null ? !performer.equals(that.performer) : that.performer != null) return false;
        if (role != that.role) return false;
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(that.dateTo) : that.dateTo != null) return false;
        if (durationFrom != null ? !durationFrom.equals(that.durationFrom) : that.durationFrom != null) return false;
        return durationTo != null ? durationTo.equals(that.durationTo) : that.durationTo == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (performer != null ? performer.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + (durationFrom != null ? durationFrom.hashCode() : 0);
        result = 31 * result + (durationTo != null ? durationTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MovieFilter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", performer='" + performer + '\'' +
                ", role=" + role +
                ", origin='" + origin + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", durationFrom=" + durationFrom +
                ", durationTo=" + durationTo +
                '}';
    }
}
