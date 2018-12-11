package com.mlasek.db;

import com.mlasek.api.MovieFilter;
import com.mlasek.core.Movie;
import com.mlasek.core.PersonRole;

import java.util.*;
import java.util.stream.Collectors;

public class DummyMovieRepository implements MovieRepository {

    public DummyMovieRepository() {
    }
    public DummyMovieRepository(List<Movie> movies) {
        this.movies = movies;
    }

    private static final String DATA_SOURCE = "starting_dummy_data.json";
    private List<Movie> movies = Collections.synchronizedList(new ArrayList<>());

    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public List<Movie> filter(MovieFilter filter) {
        return movies.stream()
                .filter(movie -> Objects.isNull(filter.getId())||
                        movie.getId().equals(filter.getId()))
                .filter(movie -> Objects.isNull(filter.getTitle())||
                        movie.getTitle().equals(filter.getTitle()))
                .filter(movie -> Objects.isNull(filter.getOrigin())||
                        Objects.isNull(movie.getCountryOfOrigin())||
                        movie.getCountryOfOrigin().equals(filter.getOrigin()))
                .filter(movie -> Objects.isNull(filter.getDateFrom())||
                        Objects.isNull(movie.getReleaseDate())||
                        movie.getReleaseDate().isEqual(filter.getDateFrom())||
                        movie.getReleaseDate().isAfter(filter.getDateFrom()))
                .filter(movie -> Objects.isNull(filter.getDateTo())||
                        Objects.isNull(movie.getReleaseDate())||
                        movie.getReleaseDate().isEqual(filter.getDateTo())||
                        movie.getReleaseDate().isBefore(filter.getDateTo()))
                .filter(movie -> Objects.isNull(filter.getGenre())||
                        movie.getGenres().isEmpty()||
                        movie.getGenres().stream()
                                .anyMatch(genre -> genre.equals(filter.getGenre())))
                .filter(movie -> anyPerformerMatch(movie,filter.getPerformer(),filter.getRole()))
                .filter(movie -> Objects.isNull(filter.getDurationFrom())||
                        Objects.isNull(movie.getDuration())||
                        movie.getDuration()>=filter.getDurationFrom())
                .filter(movie -> Objects.isNull(filter.getDurationTo())||
                        Objects.isNull(movie.getDuration())||
                        movie.getDuration()<=filter.getDurationTo())
                .collect(Collectors.toList());
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

    //As searching for any movie that has any Actor/Director/Screenwriter makes no sense(every movie has those,
    // even if that data is not filled in), this method assumes that if you have specified only the role to filter by
    //it will return true for every movie. Otherwise, if both role and performer are filled it only returns true for movies that
    //have that performer in that particular role.
    private boolean anyPerformerMatch(Movie movie,String performerName, PersonRole role){
            return movie.getPerformers().stream().anyMatch(performance ->
                    Objects.isNull(performerName)||
                            (performance.getPerformerName().equals(performerName)&&
                                    (Objects.isNull(role)||
                                    performance.getRole().equals(role))));

    }

}
