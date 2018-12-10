package com.mlasek.resources;

import com.mlasek.api.MovieFilter;
import com.mlasek.core.Movie;
import com.mlasek.core.MovieGenre;
import com.mlasek.core.PersonRole;
import com.mlasek.db.MovieRepository;
import io.dropwizard.jersey.jsr310.LocalDateParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    public MovieResource(MovieRepository repository) {
        this.repository = repository;
    }

    private MovieRepository repository;

    @GET
    public Movie movie(
            @QueryParam("id") UUID id,
            @QueryParam("title") String title,
            @QueryParam("genre") MovieGenre genre,
            @QueryParam("performer") String performer,
            @QueryParam("role") PersonRole role,
            @QueryParam("origin") String origin,
            @QueryParam("dateFrom") LocalDateParam dateFrom,
            @QueryParam("dateTo") LocalDateParam dateTo) {

        MovieFilter filter = new MovieFilter.MovieFilterBuilder()
                .withDateFrom(dateFrom)
                .withDateTo(dateTo)
                .withGenre(genre)
                .withId(id)
                .withOrigin(origin)
                .withPerformer(performer)
                .withRole(role)
                .withTitle(title)
                .build();

        return repository.findById(id)
                .orElseThrow(() ->
                        new WebApplicationException("Movie not found", 404));
    }

    @GET
    public List<Movie> allMovies(){
        return repository.findAll();
    }

    @POST
    public Movie create(Movie movie) {
        return repository.save(movie);
    }

    @PUT
    @Path("{id}")
    public Movie update(@PathParam("id") UUID id, Movie movie) {
        return repository.update(id, movie)
                .orElseThrow(() ->
                        new WebApplicationException("Movie not found", 404));
    }
}