package com.mlasek.resources;

import com.mlasek.core.Movie;
import com.mlasek.db.MovieRepository;

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
    @Path("{id}")
    public Movie movie(@PathParam("id") UUID id) {
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
