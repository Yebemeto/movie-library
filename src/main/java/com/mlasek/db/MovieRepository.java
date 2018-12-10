package com.mlasek.db;

import com.mlasek.api.MovieFilter;
import com.mlasek.core.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRepository {

    List<Movie> findAll();
    List<Movie> filter(MovieFilter filter);
    Optional<Movie> findById(UUID id);
    Movie save(Movie movie);
    Optional<Movie> update(UUID id, Movie movie);
    void delete(UUID id);
}
