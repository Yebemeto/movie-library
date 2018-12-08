package com.mlasek.db;

import com.mlasek.core.Movie;

import java.util.*;

public class DummyMovieRepository implements MovieRepository {

    private List<Movie> movies = Collections.synchronizedList(new ArrayList<>());

    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public Optional<Movie> findById(UUID id) {
        return movies.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public Movie save(Movie movie) {
        movie.setId(UUID.randomUUID());
        movies.add(movie);
        return movie;
    }

    @Override
    public Optional<Movie> update(UUID id, Movie movie) {
        Optional<Movie> existingMovie = findById(id);
        existingMovie.ifPresent(e -> e.updateIgnoreId(movie));
        return existingMovie;
    }

    @Override
    public void delete(UUID id) {
        movies.removeIf(e -> e.getId().equals(id));
    }
}
