package com.mlasek.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.mlasek.core.Movie;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class DummyMovieRepository implements MovieRepository {
    public DummyMovieRepository() {
        try {
            initializeDummyData();
        } catch (IOException e) {
            throw new RuntimeException(
                    DATA_SOURCE + "missing or unreadable", e);
        }
    }

    private static final String DATA_SOURCE = "starting_dummy_data.json";
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

    private void initializeDummyData() throws IOException {
        URL url = Resources.getResource(DATA_SOURCE);
        String json = Resources.toString(url, Charsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        CollectionType type = mapper
                .getTypeFactory()
                .constructCollectionType(List.class, Movie.class);
        movies = mapper.readValue(json,type);
    }

}
